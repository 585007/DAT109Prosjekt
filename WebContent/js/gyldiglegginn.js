"use strict";
console.log("script på");

let validFor;
let ANY_CAPITAL_LETTER = "[A-ZÆØÅ]";
let ANY_LETTER_OR_DIGIT_WITH_SPACE_HYPHEN = "[a-zA-ZæøåÆØÅ0-9 \\-]";
let TWO_TO_20_TIMES = "{2,20}";

let regex = new RegExp("^"+ANY_CAPITAL_LETTER+ANY_LETTER_OR_DIGIT_WITH_SPACE_HYPHEN+TWO_TO_20_TIMES+"$")

const rootElm = document.getElementById('root');

const proElm = rootElm.querySelector('input[name="navn"]');

function proCheck() {
  if (regex.test(proElm.value)) {
    proElm.style.borderColor = "green";
    validFor = true;
  } else {
    proElm.style.borderColor = "red";
    validFor = false;
  }
}
proElm.addEventListener('input', proCheck);
proElm.addEventListener('mouseout', proCheck);

