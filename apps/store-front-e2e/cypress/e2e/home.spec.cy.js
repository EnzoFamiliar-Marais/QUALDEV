describe('Page d\'accueil', () => {
    it('devrait afficher le titre correct', () => {
        cy.visit('/'); // Visite la page d'accueil
        cy.contains('h1', 'Store Management'); // Vérifie que le titre est correct
    });

    it('devrait naviguer vers la page créer un produit', () => {
        cy.visit('/'); // Visite la page d'accueil
        cy.get('[class="text-primary-400"]').click(); // Clique sur l'élément avec la classe spécifiée
        cy.url().should('include', '/registry/products/new'); // Vérifie que l'URL est correcte
    });
});

