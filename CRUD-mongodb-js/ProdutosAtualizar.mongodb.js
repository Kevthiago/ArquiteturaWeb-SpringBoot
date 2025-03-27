const database = 'Aula'
const collection = 'Produtos'

use(database)

//UPDATE
const inventarioStatus = db[collection].find({status: "SP"}).toArray();
print("Itens com status SP no inventário: ");
printjson(inventarioStatus);