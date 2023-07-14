import {ref} from 'vue'
import axios from 'axios'

class Produit {
    constructor(id, nom, quantite) {
        this.id = id;
        this.nom = nom;
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

        function getAllProduct() {
            return axios.get('product');
        }

        function addProduct(nom, quantite) {
            console.log('ajout de \''+nom+'\' '+quantite);
            return axios.post('product', {
                nom: nom,
                quantite: quantite
            }).then(response=>{
                console.log('addProduct ok',response);
            }).catch(reason => {
                console.error('error addProduct',reason);
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
                                    tab.push(new Produit(product.id, product.nom, product.quantite || 0));
                                }
                            }
                            listeProduits.value =tab;
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
            addProduct(formulaireNom.value, formulaireQuantite.value)
                .then(()=>{
                    initialiseListeProduits();
                });
            initialiseListeProduits();
        }

        initialiseListeProduits();

        return {
            count, listeProduits, message,
            formulaireNom, formulaireQuantite, ajouteProduit
        }
    }
}