import{t as c,a as f}from"./DZO9jai5.js";import"./B2eBMmQY.js";import{p as w,a as u,g as p,W as b,X as h}from"./CEIj9qLB.js";import{b as v}from"./ChIiEH3w.js";import{i as y}from"./BfdWj0U3.js";import{p as g}from"./U2pcgji_.js";import{o as C}from"./C1aCGczL.js";import{s as i}from"./HRuBDGzW.js";var L=c('<div class="shadow-host"></div>');function _(m,s){w(s,!1);let n=g(s,"html",8,""),r=b();function d(t){const e=p(r).shadowRoot||p(r).attachShadow({mode:"open"});e.innerHTML="";const l=document.createElement("style");l.textContent=`
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
      `;const a=document.createElement("div");a.className="wrapper",a.classList.add(i.isDark?"dark-mode":""),a.classList.add(i.animationSpeed),a.classList.add(i.primaryColor),a.innerHTML=t,e.appendChild(l),e.appendChild(a)}C(()=>{d(n())}),y();var o=L();v(o,t=>h(r,t),()=>p(r)),f(m,o),u()}export{_ as R};
