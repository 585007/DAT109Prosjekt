"use strict";
console.log("script på");
let validMob;

const rootElm = document.getElementById('root');
const formElm = rootElm.querySelector('form[name="skjema"]');
const mobElm = rootElm.querySelector('input[name="tlf"]');

let regex = new RegExp("^[0-9]{8}$");
function mobCheck() {
  if (regex.test(mobElm.value)) {
    mobElm.style.borderColor = "green";
    validMob = true;
  } else {
    mobElm.style.borderColor = "red";
    validMob = false;
  }
}
mobElm.addEventListener('input', mobCheck);

formElm.addEventListener('submit',function (event) {
  if (!validMob()) {
    alert('invalid data')
    event.preventDefault()
  }
})

