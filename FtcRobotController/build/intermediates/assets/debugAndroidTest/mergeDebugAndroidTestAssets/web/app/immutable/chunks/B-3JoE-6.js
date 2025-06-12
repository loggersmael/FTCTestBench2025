import{t as c,a as f}from"./D8d8mXFq.js";import"./CNAD40Cq.js";import{p as w,g as p,W as u,X as b,a as h}from"./C8PXpfSU.js";import{b as v}from"./BqAhEWNk.js";import{i as y}from"./WZNFhwIf.js";import{p as g}from"./7hDFcALm.js";import{o as C}from"./ByTDSDli.js";import{s as i}from"./CWqsxtux.js";var L=c('<div class="shadow-host"></div>');function _(m,s){w(s,!1);let n=g(s,"html",8,""),r=u();function d(t){const e=p(r).shadowRoot||p(r).attachShadow({mode:"open"});e.innerHTML="";const l=document.createElement("style");l.textContent=`
        .wrapper {
        --bg: #f6f6f6;
        --card: #ffffff;
        --cardTransparent: #ffffff50;
        --text: #1b1b1b;

        --primary: #e60012;
        --primary: #005bac;
        }

        .wrapper.dark-mode {
        --bg: #1b1b1b;
        --card: #131314;
        --cardTransparent: #13131450;
        --text: #c4c7c5;
        }
        .wrapper.instant {
        --multiplier: 0;
        }
        .wrapper.fast {
        --multiplier: 0.1;
        }
        .wrapper.normal {
        --multiplier: 0.15;
        }
        .wrapper.slow {
        --multiplier: 0.225;
        }
        .wrapper {
        --d: calc(var(--multiplier) * 1s);
        --d1: calc(var(--multiplier) * 1s);
        --d2: calc(var(--multiplier) * 2s);
        --d3: calc(var(--multiplier) * 3s);
        }

        .wrapper.blue {
        --primary: #005bac;
        }
        .wrapper.red {
        --primary: #e60012;
        }
      `;const a=document.createElement("div");a.className="wrapper",a.classList.add(i.isDark?"dark-mode":""),a.classList.add(i.animationSpeed),a.classList.add(i.primaryColor),a.innerHTML=t,e.appendChild(l),e.appendChild(a)}C(()=>{d(n())}),y();var o=L();v(o,t=>b(r,t),()=>p(r)),f(m,o),h()}export{_ as R};
