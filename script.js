document.getElementById('contactForm').addEventListener('submit', async function(e) {
    e.preventDefault();
    
    const name = document.getElementById('name').value.trim();
    const email = document.getElementById('email').value.trim();
    const message = document.getElementById('message').value.trim();
    const resultDiv = document.getElementById('result');
    
    // Валидация
    if (!name || !email || !message) {
        resultDiv.textContent = "Пожалуйста, заполните все поля.";
        resultDiv.className = 'error';
        return;
    }
    
    try {
        const response = await fetch('http://158.160.145.245:8056/api/feedback', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ name, email, message })
        });
        
        if (response.ok) {
            resultDiv.textContent = "Спасибо! Ваше сообщение отправлено.";
            resultDiv.className = 'success';
            document.getElementById('contactForm').reset();
        } else {
            throw new Error('Ошибка сервера');
        }
    } catch (error) {
        console.error('Error:', error);
        resultDiv.textContent = "Произошла ошибка при отправке. Пожалуйста, попробуйте позже.";
        resultDiv.className = 'error';
    }
});