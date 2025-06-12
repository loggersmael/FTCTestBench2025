import{t as h,a as v}from"./ChmJhFlX.js";import{p as y,u as k,a as x,g as f,b as C,e as E}from"./CsWiMj7x.js";import{p as L}from"./BNq_iqLs.js";import{b as A}from"./ydSpFQVl.js";import{p as M}from"./DLju50SL.js";import{o as R}from"./DmcLPeLh.js";import{i as S,s as T}from"./C27U-dM-.js";import{s as d}from"./C7ewnLZJ.js";/* empty css        */var j=h('<div class="shadow-host svelte-1kuj9kb"></div>');function G(u,s){y(s,!0);let g=M(s,"id",3,""),o,p=C(null);k(()=>{if(f(p)==null)return;const a=f(p).querySelectorAll(".dynamic");S.plugins.forEach(t=>{const i=t.globalVariables;a.forEach(e=>{var n;const r=(n=e.getAttribute("data-key"))==null?void 0:n.trim();r&&i[r]&&(e.textContent=i[r])})})});function w(a){const t=o.shadowRoot||o.attachShadow({mode:"open"});E(p,L(t)),t.innerHTML="";const i=document.createElement("style");i.textContent=`
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
      .wrapper{
        width: 100%;
        height: 100%;
      }
      iframe{
        outline: none;
        border: none;
        background-color:white;
      }

      .widget-header {
        display: flex;
        gap: 1rem;
        justify-content: space-between;
        align-items: center;
        position: relative;
        margin-inline: 1rem;
        padding-top: 0.5rem;
        margin-bottom: 0.5rem;
      }

      .widget-header > p {
        margin: 0;
        text-align: center;
        flex-grow: 1;
        font-size: 1.25rem;
        font-weight: bold;
      }
    `;const e=document.createElement("div");e.className="wrapper",e.id="wrapper",e.classList.add(d.isDark?"dark-mode":""),e.classList.add(d.animationSpeed),e.classList.add(d.primaryColor),e.innerHTML=a;const r=n=>{const m=n.target;if(m.matches("button.action")){const l=m.getAttribute("data-action");if(l!==null){console.log("Action triggered:",l);var b={kind:"pluginsAction",id:g(),action:l};T.sendMessage(b)}}};return t.addEventListener("click",r),t.appendChild(i),t.appendChild(e),()=>{t.removeEventListener("click",r)}}R(()=>{w(s.html)});var c=j();A(c,a=>o=a,()=>o),v(u,c),x()}export{G as R};
