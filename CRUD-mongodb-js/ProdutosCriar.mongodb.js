const database = 'Aula';
const collection = 'Produtos';

use(database);

db[collection].insertMany([
    {
        item: 'canvas',
        qtd: 20,
        size: {h: 28, w: 35.5},
        status: 'SP',
    },
    {
        item: 'pincel',
        qtd: 50,
        size: {h: 15, w: 2},
        status: 'SP',
    },
    {
        item: 'tinta acrílica',
        qtd: 30,
        size: {h: 12, w: 10},
        status: 'RJ',
    },
    {
        item: 'pasta A4',
        qtd: 100,
        size: {h: 32, w: 24},
        status: 'MG',
    },
    {
        item: 'caneta preta',
        qtd: 150,
        size: {h: 14, w: 1.5},
        status: 'SP',
    },
    {
        item: 'papel cartão',
        qtd: 200,
        size: {h: 60, w: 40},
        status: 'BA',
    },
    {
        item: 'tesoura',
        qtd: 40,
        size: {h: 20, w: 6},
        status: 'ES',
    },
    {
        item: 'cola branca',
        qtd: 75,
        size: {h: 20, w: 6},
        status: 'PR',
    },
    {
        item: 'papeis coloridos',
        qtd: 150,
        size: {h: 25, w: 20},
        status: 'RS',
    },
    {
        item: 'tinta óleo',
        qtd: 10,
        size: {h: 10, w: 8},
        status: 'SP',
    }
]);
