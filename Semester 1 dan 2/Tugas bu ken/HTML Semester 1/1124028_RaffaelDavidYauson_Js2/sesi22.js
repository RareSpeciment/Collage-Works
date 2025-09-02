function max(){
    let mhs = new Array(3);

    for (let i = 0; i < mhs.length; i++){
        //mhs[i] = prompt("Bilangan ke " + (i + 1));
        mhs[i] = parseInt(prompt("Bilangan ke " + (i + 1)));
    }

    let tinggi = mhs[0];
    for (let i = 1; i < mhs.length; i++){
        if(mhs[i] > tinggi){
            tinggi = mhs[i];   
        }
    }

    alert("Bilangan no 1 : " + mhs[0] + " Bilangan no 2 : " + mhs[1] + " Bilangan no 3 : " + mhs[2]);
    alert("Bilangan tertinggi adalah : " + tinggi);
}

function checkArray() {

    var arrayLength = parseInt(document.getElementById('panjangarray').value);
    var myArray = [];

    for (var i = 0; i < arrayLength; i++) {
        var element = prompt('Masukkan elemen ke-' + (i + 1));
        myArray.push(element);
    }
    
    var valueToCheck = document.getElementById('pengecekan').value;

    if (myArray.includes(valueToCheck)) {
        document.getElementById('hasil').innerHTML = "Nilai '" + valueToCheck + "' ditemukan dalam array.";
    } else {
        document.getElementById('hasil').innerHTML = "Nilai '" + valueToCheck + "' tidak ditemukan dalam array.";
    }
}

function factorial(n) {
    let result = 1;
    for (let i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}

function generate() {

    let n = parseInt(prompt("Masukkan angka N untuk menghitung faktor-faktorial:"));

    if (isNaN(n) || n < 0) {
        alert("Input tidak valid, harap masukkan angka positif.");
        return;
    }

    let resultText = "<h2>Hasil Faktorial:</h2>";
    for (let i = 0; i <= n; i++) {
        resultText += `<p>Faktorial dari ${i} adalah: ${factorial(i)}</p>`;
    }
    
    document.getElementById('factorial-results').innerHTML = resultText;
}
