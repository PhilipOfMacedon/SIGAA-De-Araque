import emailValidator from '../rules/email';

export default {
    getMessage() {
        return "Email inválido"
    },
    validate(value) {
        return emailValidator(value);
    }
}