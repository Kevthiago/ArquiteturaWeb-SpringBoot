const database = 'Aula'
const collection = 'Produtos'

use(database)

//GET GERAL - EXEMPLO
//const inventario = db[collection].find();
//print("Itens cadastrados no inventário: ");
//printjson(inventario);

//GET ESPECÍFICO - EXEMPLO
const inventarioStatus = db[collection].find({status: "SP"}).toArray();
print("Itens com status SP no inventário: ");
printjson(inventarioStatus);