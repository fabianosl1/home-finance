export function formatCurrency(value: number) {
    return value.toLocaleString('pt-br', {minimumFractionDigits: 2, maximumFractionDigits: 2})
}