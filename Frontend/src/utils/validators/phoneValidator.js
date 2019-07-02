import phoneValidate from '../rules/phone'

const validator = {
    getMessage() {
        return "Telefone de contato inválido"
    },
    validate(value) {
        return phoneValidate(value);
    }
}

export default validator;