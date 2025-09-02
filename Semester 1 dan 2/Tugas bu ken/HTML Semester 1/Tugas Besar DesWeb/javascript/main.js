document.getElementById('feedbackForm').addEventListener('submit', function(e) {
    e.preventDefault();
    
    const nama = document.getElementById('nama').value;
    const pesan = document.getElementById('pesan').value;
    
    const feedbackDisplay = document.getElementById('feedbackDisplay');
    const newFeedback = document.createElement('div');
    newFeedback.innerHTML = `<p><strong>${nama}</strong>: ${pesan}</p>`;
    newFeedback.style.marginBottom = '10px';
    newFeedback.style.borderBottom = '1px solid #ccc';
    newFeedback.style.paddingBottom = '5px';
    
    feedbackDisplay.appendChild(newFeedback);
    
    // Reset form
    this.reset();
});