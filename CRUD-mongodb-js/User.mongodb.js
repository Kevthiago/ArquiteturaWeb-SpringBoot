const database = 'Aula'
const collection = 'Users'

use(database);

db[collection].insertOne({
    nome: 'Daniel Silva e Silva',
    idade: 20,
    pais: 'Brasil',
    estado: 'SP',
    cidade: 'São Paulo',
});