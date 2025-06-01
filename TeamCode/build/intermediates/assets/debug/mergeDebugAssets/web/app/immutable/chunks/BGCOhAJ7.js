import{t as h,a as b}from"./BjvQRzAE.js";import{o as v,w as g}from"./6i5jw-Z5.js";import{b as k}from"./BNirIX8U.js";import{p as y}from"./akmpVM9F.js";import{o as L}from"./Cp8OyfFa.js";import{s as C}from"./DvMgljZu.js";import{s}from"./BvBwtrQU.js";var E=h('<div class="shadow-host"></div>');function j(l,e){v(e,!0);let m=y(e,"id",3,""),a;function f(i){const r=a.shadowRoot||a.attachShadow({mode:"open"});r.innerHTML="";const p=document.createElement("style");p.textContent=`
      .wrapper {
        --bg: #f6f6f6;
        --card: #ffffff;
        --cardTransparent: #ffffff50;
        --text: #1b1b131414;

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
    `;const t=document.createElement("div");t.className="wrapper",t.classList.add(s.isDark?"dark-mode":""),t.classList.add(s.animationSpeed),t.classList.add(s.primaryColor),t.innerHTML=i;const c=u=>{const d=u.target;if(d.matches("button.action")){const o=d.getAttribute("data-action");if(o!==null){console.log("Action triggered:",o);var w={id:m(),action:o};C.sendMessage(w)}}};return r.addEventListener("click",c),r.appendChild(p),r.appendChild(t),()=>{r.removeEventListener("click",c)}}L(()=>{f(e.html)});var n=E();k(n,i=>a=i,()=>a),b(l,n),g()}export{j as R};
