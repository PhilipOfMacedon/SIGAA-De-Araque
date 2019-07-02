import CpfValidate from '../rules/cpf'
const validator = {
    getMessage() { 
        return 'CPF Inválido'
    },
    validate(value) {
        return CpfValidate(value)
    }
}
export default validator
