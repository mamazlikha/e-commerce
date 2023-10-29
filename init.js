// Item schema
db.createCollection("item", { validator: { $jsonSchema: { bsonType: "object", required: ["description", "name", "price"],properties: { id: {  bsonType: "objectId", description: "Auto-generated item's id" },description: { bsonType: "string", description: "Item's description"},name: { bsonType: "string", description: "Item's name"},price: { bsonType: "double", description: "Item's price"}}}}})

// Populate with items

// Function to generate a random item
function generateRandomItem() {
    var description = "Item Description " + Math.floor(Math.random() * 1000);
    var name = "Item Name " + Math.floor(Math.random() * 1000);
    var price = Math.random() * 100; // Random price between 0 and 100
    return {
        id: ObjectId(), // MongoDB will generate a unique ObjectId for the id field
        description: description,
        name: name,
        price: price
    };
}

// Insert 100 random items into the 'item' collection
for (var i = 0; i < 100; i++) {
    var item = generateRandomItem();
    db.item.insertOne(item);
}



// Cart schema
db.createCollection("cart", { validator: { $jsonSchema: { bsonType: "object",required: ["items", "totalPrice"], properties: { _id: { bsonType: "objectId", description: "Cart's unique identifier" }, items: {bsonType: "array", description: "Array of ItemEntity references", items: { bsonType: "object", properties: { _id: {  bsonType: "objectId", description: "Auto-generated item's id" }, description: { bsonType: "string", description: "Item's description"},name: { bsonType: "string", description: "Item's name"},price: { bsonType: "double", description: "Item's price"}}} }, totalPrice: { bsonType: "double", description: "Total price of the cart" }}}}})

// User schema

