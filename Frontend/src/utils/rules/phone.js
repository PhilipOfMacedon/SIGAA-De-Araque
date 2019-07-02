function regex() {
    return RegExp(/^\(\d{2}\) \d{4,5}-\d{4}$/gi);
}

function validate(value) {
    let re = regex();
    // value = value.replace(/\s/g, "");
    console.log(value);
    return re.test(value);
}

export default validate;
