import{t as b,a as v}from"./I_BkWTEX.js";import{p as y,W as k,a as x,g as f,X as C,Y as E}from"./CFBpeVWW.js";import{p as L}from"./Df3xjQUJ.js";import{b as A}from"./RxjphwwN.js";import{p as M}from"./B9fIG9m6.js";import{o as R}from"./B_eryhZ5.js";import{i as S,s as T}from"./CEYokUmH.js";import{s as d}from"./Cpx5LP4m.js";/* empty css        */var j=b('<div class="shadow-host svelte-1kuj9kb"></div>');function Y(u,s){y(s,!0);let g=M(s,"id",3,""),o,l=C(null);k(()=>{if(f(l)==null)return;const a=f(l).querySelectorAll(".dynamic");S.plugins.forEach(t=>{const i=t.globalVariables;a.forEach(e=>{var n;const r=(n=e.getAttribute("data-key"))==null?void 0:n.trim();r&&i[r]&&(e.textContent=i[r])})})});function w(a){const t=o.shadowRoot||o.attachShadow({mode:"open"});E(l,L(t)),t.innerHTML="";const i=document.createElement("style");i.textContent=`
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
    `;const e=document.createElement("div");e.className="wrapper",e.classList.add(d.isDark?"dark-mode":""),e.classList.add(d.animationSpeed),e.classList.add(d.primaryColor),e.innerHTML=a;const r=n=>{const m=n.target;if(m.matches("button.action")){const p=m.getAttribute("data-action");if(p!==null){console.log("Action triggered:",p);var h={kind:"pluginsAction",id:g(),action:p};T.sendMessage(h)}}};return t.addEventListener("click",r),t.appendChild(i),t.appendChild(e),()=>{t.removeEventListener("click",r)}}R(()=>{w(s.html)});var c=j();A(c,a=>o=a,()=>o),v(u,c),x()}export{Y as R};
