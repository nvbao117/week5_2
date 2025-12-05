// Admin JavaScript functions

// Delete tour confirmation
function deleteTour(tourId) {
    if (confirm('Bạn có chắc chắn muốn xóa tour này?')) {
        // Create form and submit
        const form = document.createElement('form');
        form.method = 'POST';
        form.action = '/admin/tours/' + tourId + '/delete';

        // Add CSRF token if using Spring Security
        const csrfToken = document.querySelector('meta[name="_csrf"]');
        const csrfHeader = document.querySelector('meta[name="_csrf_header"]');

        if (csrfToken && csrfHeader) {
            const input = document.createElement('input');
            input.type = 'hidden';
            input.name = csrfToken.getAttribute('content');
            input.value = csrfHeader.getAttribute('content');
            form.appendChild(input);
        }

        document.body.appendChild(form);
        form.submit();
    }
}

// Update booking status
function updateStatus(bookingId, status) {
    const statusText = status === 'PAID' ? 'đã thanh toán' : 'chưa thanh toán';

    if (confirm('Xác nhận cập nhật trạng thái thành ' + statusText + '?')) {
        // Create form and submit
        const form = document.createElement('form');
        form.method = 'POST';
        form.action = '/admin/bookings/' + bookingId + '/status';

        // Add status field
        const statusInput = document.createElement('input');
        statusInput.type = 'hidden';
        statusInput.name = 'status';
        statusInput.value = status;
        form.appendChild(statusInput);

        // Add CSRF token if using Spring Security
        const csrfToken = document.querySelector('meta[name="_csrf"]');
        const csrfHeader = document.querySelector('meta[name="_csrf_header"]');

        if (csrfToken && csrfHeader) {
            const input = document.createElement('input');
            input.type = 'hidden';
            input.name = csrfToken.getAttribute('content');
            input.value = csrfHeader.getAttribute('content');
            form.appendChild(input);
        }

        document.body.appendChild(form);
        form.submit();
    }
}

// Auto-hide alerts after 5 seconds
document.addEventListener('DOMContentLoaded', function () {
    const alerts = document.querySelectorAll('.alert');
    alerts.forEach(function (alert) {
        setTimeout(function () {
            alert.style.opacity = '0';
            setTimeout(function () {
                alert.remove();
            }, 300);
        }, 5000);
    });
});
