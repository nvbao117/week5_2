// Booking page JavaScript

document.addEventListener('DOMContentLoaded', function() {
    const numberOfPeopleInput = document.getElementById('numberOfPeople');
    const decreaseBtn = document.getElementById('decreaseBtn');
    const increaseBtn = document.getElementById('increaseBtn');
    const peopleCountSpan = document.getElementById('peopleCount');
    const tourPriceSpan = document.getElementById('tourPrice');
    const totalPriceSpan = document.getElementById('totalPrice');
    
    // Get base price from data attribute
    const basePrice = parseInt(tourPriceSpan.getAttribute('data-price'));
    const maxPeople = parseInt(numberOfPeopleInput.getAttribute('max'));
    
    // Update price calculation
    function updatePrice() {
        const numberOfPeople = parseInt(numberOfPeopleInput.value) || 1;
        const totalPrice = basePrice * numberOfPeople;
        
        // Update display
        peopleCountSpan.textContent = numberOfPeople;
        tourPriceSpan.textContent = formatNumber(totalPrice) + ' đ';
        totalPriceSpan.textContent = formatNumber(totalPrice) + ' đ';
    }
    
    // Format number with thousand separators
    function formatNumber(num) {
        return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    }
    
    // Decrease button
    if (decreaseBtn) {
        decreaseBtn.addEventListener('click', function() {
            let currentValue = parseInt(numberOfPeopleInput.value) || 1;
            if (currentValue > 1) {
                numberOfPeopleInput.value = currentValue - 1;
                updatePrice();
            }
        });
    }
    
    // Increase button
    if (increaseBtn) {
        increaseBtn.addEventListener('click', function() {
            let currentValue = parseInt(numberOfPeopleInput.value) || 1;
            if (currentValue < maxPeople) {
                numberOfPeopleInput.value = currentValue + 1;
                updatePrice();
            }
        });
    }
    
    // Input change
    if (numberOfPeopleInput) {
        numberOfPeopleInput.addEventListener('input', function() {
            let value = parseInt(this.value) || 1;
            
            // Validate range
            if (value < 1) value = 1;
            if (value > maxPeople) value = maxPeople;
            
            this.value = value;
            updatePrice();
        });
    }
    
    // Form validation
    const bookingForm = document.getElementById('bookingForm');
    if (bookingForm) {
        bookingForm.addEventListener('submit', function(e) {
            const agreeTerms = document.getElementById('agreeTerms');
            
            if (!agreeTerms.checked) {
                e.preventDefault();
                alert('Vui lòng đồng ý với điều khoản và điều kiện');
                return false;
            }
            
            // Additional validation can be added here
            return true;
        });
    }
});
