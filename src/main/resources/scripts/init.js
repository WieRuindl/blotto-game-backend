db = connect("mongodb://admin:password@localhost:27017/admin");

// Switch to the blotto_db database
db = db.getSiblingDB('blotto_db');

// Create the admin user with readWrite role for blotto_db
db.createUser({
    user: "admin",
    pwd: "password",
    roles: [ { role: "readWrite", db: "blotto_db" } ]
});
