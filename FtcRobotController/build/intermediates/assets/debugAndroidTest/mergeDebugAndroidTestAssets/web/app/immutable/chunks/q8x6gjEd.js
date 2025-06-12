import{t as g,a as v}from"./I_BkWTEX.js";import{p as k,W as y,a as C,g as f,X as E,Y as L}from"./CFBpeVWW.js";import{p as x}from"./Df3xjQUJ.js";import{b as A}from"./RxjphwwN.js";import{p as M}from"./B9fIG9m6.js";import{o as R}from"./B_eryhZ5.js";import{i as S,s as T}from"./CEYokUmH.js";import{s as c}from"./Cpx5LP4m.js";/* empty css        */var j=g('<div class="shadow-host svelte-1kuj9kb"></div>');function z(u,s){k(s,!0);let h=M(s,"id",3,""),o,p=E(null);y(()=>{if(f(p)==null)return;const a=f(p).querySelectorAll(".dynamic");S.plugins.forEach(e=>{const i=e.globalVariables;a.forEach(t=>{var n;const r=(n=t.getAttribute("data-key"))==null?void 0:n.trim();r&&i[r]&&(t.textContent=i[r])})})});function b(a){const e=o.shadowRoot||o.attachShadow({mode:"open"});L(p,x(e)),e.innerHTML="";const i=document.createElement("style");i.textContent=`
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
    `;const t=document.createElement("div");t.className="wrapper",t.classList.add(c.isDark?"dark-mode":""),t.classList.add(c.animationSpeed),t.classList.add(c.primaryColor),t.innerHTML=a;const r=n=>{const m=n.target;if(m.matches("button.action")){const l=m.getAttribute("data-action");if(l!==null){console.log("Action triggered:",l);var w={kind:"pluginsAction",id:h(),action:l};T.sendMessage(w)}}};return e.addEventListener("click",r),e.appendChild(i),e.appendChild(t),()=>{e.removeEventListener("click",r)}}R(()=>{b(s.html)});var d=j();A(d,a=>o=a,()=>o),v(u,d),C()}export{z as R};
