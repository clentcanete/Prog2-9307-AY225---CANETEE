// Programmer Identifier: [CLENT AGAN CANETE] [24-1917-717]
// Student Records Management System - JavaScript Implementation

// Hardcoded CSV content
const CSV_DATA = `ID,Name,Lab1,Lab2,Lab3,Prelim,Attendance
101,Alice Johnson,90,88,92,89,95
102,Bob Smith,85,80,83,84,90
103,Charlie Davis,92,91,94,93,98
104,Diana Prince,88,86,85,87,92
105,Ethan Hunt,95,94,96,97,99`;

// Parse CSV data into array of objects
function parseCSV(csvString) {
    const lines = csvString.trim().split('\n');
    const headers = lines[0].split(',');
    const records = [];

    for (let i = 1; i < lines.length; i++) {
        const values = lines[i].split(',');
        const record = {};
        for (let j = 0; j < headers.length; j++) {
            record[headers[j].trim()] = values[j].trim();
        }
        records.push(record);
    }
    return records;
}

// Initialize records
let studentRecords = parseCSV(CSV_DATA);

// Render table
function render() {
    const tableBody = document.getElementById('tableBody');
    tableBody.innerHTML = '';

    studentRecords.forEach((student, index) => {
        const row = `
            <tr>
                <td>${student.ID}</td>
                <td>${student.Name}</td>
                <td>${student.Lab1}</td>
                <td>${student.Lab2}</td>
                <td>${student.Lab3}</td>
                <td>${student.Prelim}</td>
                <td>${student.Attendance}</td>
                <td>
                    <button class="btn btn-delete" onclick="deleteRecord(${index})">Delete</button>
                </td>
            </tr>
        `;
        tableBody.innerHTML += row;
    });

    updateRecordCount();
}

// Add new record
function addRecord(event) {
    event.preventDefault();

    const newStudent = {
        ID: document.getElementById('studentId').value.trim(),
        Name: document.getElementById('studentName').value.trim(),
        Lab1: document.getElementById('lab1').value.trim(),
        Lab2: document.getElementById('lab2').value.trim(),
        Lab3: document.getElementById('lab3').value.trim(),
        Prelim: document.getElementById('prelim').value.trim(),
        Attendance: document.getElementById('attendance').value.trim()
    };

    // Validation: check all fields filled
    for (let key in newStudent) {
        if (!newStudent[key]) {
            alert('Please fill in all fields!');
            return;
        }
    }

    // Validation: numeric fields
    const numericFields = ['Lab1', 'Lab2', 'Lab3', 'Prelim', 'Attendance'];
    for (let field of numericFields) {
        if (isNaN(newStudent[field]) || Number(newStudent[field]) < 0) {
            alert(`${field} must be a valid number!`);
            return;
        }
    }

    studentRecords.push(newStudent);
    render();

    document.getElementById('studentForm').reset();
    document.getElementById('studentId').focus();

    showMessage('Record added successfully!', 'success');
}

// Delete record
function deleteRecord(index) {
    if (confirm('Are you sure you want to delete this record?')) {
        studentRecords.splice(index, 1);
        render();
        showMessage('Record deleted successfully!', 'success');
    }
}

// Update record count
function updateRecordCount() {
    const count = studentRecords.length;
    document.querySelector('.table-section h2').textContent =
        `Student Records (${count} total)`;
}

// Show message
function showMessage(message, type) {
    const messageDiv = document.createElement('div');
    messageDiv.className = `message message-${type}`;
    messageDiv.textContent = message;

    const container = document.querySelector('.container');
    container.insertBefore(messageDiv, container.firstChild);

    setTimeout(() => messageDiv.remove(), 3000);
}

// Initialize
document.addEventListener('DOMContentLoaded', () => {
    render();
    document.getElementById('studentForm').addEventListener('submit', addRecord);
    console.log('Student Records Application Loaded');
});
