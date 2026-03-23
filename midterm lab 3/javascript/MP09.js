// MP09 - Display dataset statistics

const fs = require("fs");
const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question("Enter CSV file path: ", (filePath) => {
    try {
        const data = fs.readFileSync(filePath, "utf-8");

        const lines = data.trim().split("\n");

        const rowCount = lines.length;
        const columnCount = lines[0].split(",").length;

        console.log("\nDataset Statistics:");
        console.log("Total Rows:", rowCount);
        console.log("Total Columns:", columnCount);

    } catch (err) {
        console.log("Error:", err.message);
    }

    rl.close();
});