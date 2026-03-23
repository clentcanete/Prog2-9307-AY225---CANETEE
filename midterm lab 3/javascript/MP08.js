// MP08 - Filter records using a keyword

const fs = require("fs");
const readline = require("readline");

// Create interface for user input
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// Ask for file path
rl.question("Enter CSV file path: ", (filePath) => {
    rl.question("Enter keyword to filter: ", (keyword) => {
        try {
            const data = fs.readFileSync(filePath, "utf-8");

            const lines = data.split("\n");
            let count = 0;

            console.log("\nFiltered Records:");

            // Loop through each row
            lines.forEach(line => {
                if (line.toLowerCase().includes(keyword.toLowerCase())) {
                    console.log(line);
                    count++;
                }
            });

            console.log("\nTotal matched records:", count);

        } catch (err) {
            console.log("Error:", err.message);
        }

        rl.close();
    });
});