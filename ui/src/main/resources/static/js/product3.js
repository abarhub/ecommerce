import {ref} from 'vue'
import axios from 'axios'

class Produit {
    constructor(id, nom, code, quantite) {
        this.id = id;
        this.nom = nom;
        this.code = code;
        this.quantite = quantite;
    }
}


export default {
    setup() {
        const count = ref(0);
        const listeProduits = ref([]);
        const message = ref('Mon message');
        const formulaireNom = ref('');
        const formulaireQuantite = ref('');
        const formulaireCode = ref('');

        function getAllProduct() {
            return axios.get('product');
        }

        function addProduct(nom, code, quantite) {
            console.log('ajout de \'' + nom + '\' ' + quantite);
            return axios.post('product', {
                nom: nom,
                code: code,
                quantite: quantite
            }).then(response => {
                console.log('addProduct ok', response);
            }).catch(reason => {
                    console.error('error addProduct', reason);
                }
            );
        }

        function initialiseListeProduits() {

            getAllProduct()
                .then(response => {
                    // en cas de réussite de la requête
                    console.log(response);
                    try {
                        if (response && response.data &&
                            response.data.uiProductDtoList && response.data.uiProductDtoList.length > 0) {
                            let tab = [];
                            for (let product of response.data.uiProductDtoList) {
                                if (product.id && product.nom) {
                                    tab.push(new Produit(product.id, product.nom, product.code, product.quantite || 0));
                                }
                            }
                            listeProduits.value = tab;
                        }
                    } catch (err) {
                        console.error('error initialiseListeProduits catch', err);
                    }
                }).catch(function (error) {
                console.error('error initialiseListeProduits url', error);
            })
        }

        function ajouteProduit() {
            console.log('ajouteProduit');
            addProduct(formulaireNom.value, formulaireCode.value, formulaireQuantite.value)
                .then(() => {
                    initialiseListeProduits();
                });
            initialiseListeProduits();
        }

        function ajouteProduitMontant(code, quantite) {
            console.log('ajouteProduitMontant', code, quantite);
            return axios.put('product/'+code+'/restock/1').then(response => {
                console.log('ajouteProduitMontant ok', response);
                initialiseListeProduits();
            }).catch(reason => {
                    console.error('error ajouteProduitMontant', reason);
                }
            );
        }

        function diminueProduitMontant(code, quantite) {
            console.log('diminueProduitMontant', code, quantite);
            if(quantite>0) {
                return axios.put('product/' + code + '/sell/1').then(response => {
                    console.log('diminueProduitMontant ok', response);
                    initialiseListeProduits();
                }).catch(reason => {
                        console.error('error diminueProduitMontant', reason);
                    }
                );
            } else {
                console.error('error diminueProduitMontant: quantity='+quantite);
            }
        }

        initialiseListeProduits();

        return {
            count, listeProduits, message,
            formulaireNom, formulaireCode, formulaireQuantite, ajouteProduit,
            ajouteProduitMontant,diminueProduitMontant
        }
    }
}