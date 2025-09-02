function toggleText(card) {
    const text = card.querySelector('.text');
    text.style.display = text.style.display === 'block' ? 'none' : 'block';
}

document.querySelectorAll('.tooltip').forEach((tooltip) => {
    const tooltipText = tooltip.querySelector('.tooltiptext');

    tooltip.addEventListener('mouseenter', () => {
        // Show the tooltip to calculate dimensions
        tooltipText.style.visibility = 'visible';
        tooltipText.style.opacity = '1';

        // Get bounding box dimensions
        const rect = tooltipText.getBoundingClientRect();
        const viewportWidth = window.innerWidth;
        const viewportHeight = window.innerHeight;

        // Adjust horizontal position
        if (rect.right > viewportWidth) {
            tooltipText.style.left = 'auto';
            tooltipText.style.right = '0';
            tooltipText.style.transform = 'translateX(0)';
        } else if (rect.left < 0) {
            tooltipText.style.left = '0';
            tooltipText.style.transform = 'translateX(0)';
        } else {
            tooltipText.style.left = '50%';
            tooltipText.style.transform = 'translateX(-50%)';
        }

        // Adjust vertical position
        if (rect.bottom > viewportHeight) {
            tooltipText.style.top = 'auto';
            tooltipText.style.bottom = '120%';
        } else {
            tooltipText.style.top = '120%';
            tooltipText.style.bottom = 'auto';
        }
    });

    tooltip.addEventListener('mouseleave', () => {
        // Reset to default styles
        tooltipText.style.visibility = 'hidden';
        tooltipText.style.opacity = '0';
        tooltipText.style.left = '50%';
        tooltipText.style.transform = 'translateX(-50%)';
        tooltipText.style.top = '120%';
        tooltipText.style.bottom = 'auto';
        tooltipText.style.right = 'auto';
    });
});