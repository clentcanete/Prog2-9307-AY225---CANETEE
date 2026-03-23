// MP10 - Detect duplicate records

const fs = require("fs");
const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question("Enter CSV file path: ", (filePath) => {
    try {
        const data = fs.readFileSync(filePath, "utf-8");

        const lines = data.split("\n");

        const unique = new Set();
        const duplicates = new Set();

        lines.forEach(line => {
            if (unique.has(line)) {
                duplicates.add(line);
            } else {
                unique.add(line);
            }
        });

        console.log("\nDuplicate Records:");
        if (duplicates.size === 0) {
            console.log("No duplicates found.");
        } else {
            duplicates.forEach(dup => console.log(dup));
        }

    } catch (err) {
        console.log("Error:", err.message);
    }

    rl.close();
});
