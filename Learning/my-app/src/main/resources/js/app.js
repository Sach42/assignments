import 'htmx.org';
import 'css/app.css';

document.querySelectorAll('.js-dropdown').forEach(($item) => {
    $item.addEventListener('click', (event) => {
        document.querySelectorAll('.js-dropdown').forEach(($dropdown) => {
            if (event.currentTarget === $dropdown ||
                    ($dropdown.getAttribute('data-dropdown-single') !== 'true' && $dropdown.ariaExpanded === 'true')) {
                $dropdown.ariaExpanded = $dropdown.ariaExpanded !== 'true';
                $dropdown.nextElementSibling.classList.toggle('hidden');
            }
        });
        return false;
    });
});
