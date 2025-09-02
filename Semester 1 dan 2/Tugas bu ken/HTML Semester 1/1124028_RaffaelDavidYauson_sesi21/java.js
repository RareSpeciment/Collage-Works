const subjects =[
    { name: "Erika", grade: 85 },
    { name: "Diskota", grade: 90 },
    { name: "Neo", grade: 80 },
    { name: "Fish", grade: 75 },
    { name: "Fiktoria", grade: 88 }
];

const gradesTable = document.getElementById("grades");

subjects.forEach(subject => {
    const row = document.createElement("tr");

    const subjectCell = document.createElement("td");
    subjectCell.textContent = subject.name;
    row.appendChild(subjectCell);

    const gradeCell = document.createElement("td");
    gradeCell.textContent = subject.grade;
    row.appendChild(gradeCell);

    gradesTable.appendChild(row);
});

function getGradeTranscript(grade) {
    if (grade >= 85) {
        return "A";
    } else if (grade >= 70) {
        return "B";
    } else if (grade >= 60) {
        return "C";
    } else {
        return "D";
    }
}

const transkripsTable = document.getElementById("TTB");

subjects.forEach(subject => {
    const row = document.createElement("tr");

    const gradeCell = document.createElement("td");
    gradeCell.textContent = subject.grade;
    row.appendChild(gradeCell);

    const transcriptCell = document.createElement("td");
    transcriptCell.textContent = getGradeTranscript(subject.grade);
    row.appendChild(transcriptCell);

    transkripsTable.appendChild(row);
});


//konversion functions
function convertToFahrenheit() {
    const celsius = document.getElementById('celsius').value;
    const fahrenheit = (celsius * 9/5) + 32;
    document.getElementById('fahrenheit').value = isNaN(fahrenheit) ? '' : fahrenheit.toFixed(2);
}

//kalkulator
function Kalkulator(operation) {
    const num1 = parseFloat(document.getElementById('num1').value);
    const num2 = parseFloat(document.getElementById('num2').value);
    let result;

    if (isNaN(num1) || isNaN(num2)) {
        result = 'Invalid Input';
    } else {
        switch (operation) {
            case 'add':
                result = num1 + num2;
                break;
            case 'subtract':
                result = num1 - num2;
                break;
            case 'multiply':
                result = num1 * num2;
                break;
            case 'divide':
                result = num2 !== 0 ? num1 / num2 : 'Cannot divide by 0';
                break;
        }
    }
    document.getElementById('result').value = result;
}

//changes colours
function changeBackgroundColor(color) {
    document.body.style.backgroundColor = color;
}
