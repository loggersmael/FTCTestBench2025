import{t as g,a as v}from"./NpSIxppV.js";import{p as y,W as k,a as C,g as f,X as E,Y as L}from"./CprfUR79.js";import{p as x}from"./CDl5DGgc.js";import{b as A}from"./CFiEScDH.js";import{p as M}from"./Ca59QxI8.js";import{o as R}from"./5BPK7fMN.js";import{i as S,s as T}from"./wsybdplX.js";import{s as c}from"./B8duggxJ.js";var H=g('<div class="shadow-host"></div>');function Y(u,n){y(n,!0);let b=M(n,"id",3,""),o,p=E(null);k(()=>{if(f(p)==null)return;const r=f(p).querySelectorAll(".dynamic");S.plugins.forEach(e=>{const i=e.globalVariables;r.forEach(t=>{var s;const a=(s=t.getAttribute("data-key"))==null?void 0:s.trim();a&&i[a]&&(t.textContent=i[a])})})});function h(r){const e=o.shadowRoot||o.attachShadow({mode:"open"});L(p,x(e)),e.innerHTML="";const i=document.createElement("style");i.textContent=`
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
    `;const t=document.createElement("div");t.className="wrapper",t.classList.add(c.isDark?"dark-mode":""),t.classList.add(c.animationSpeed),t.classList.add(c.primaryColor),t.innerHTML=r;const a=s=>{const m=s.target;if(m.matches("button.action")){const l=m.getAttribute("data-action");if(l!==null){console.log("Action triggered:",l);var w={kind:"pluginsAction",id:b(),action:l};T.sendMessage(w)}}};return e.addEventListener("click",a),e.appendChild(i),e.appendChild(t),()=>{e.removeEventListener("click",a)}}R(()=>{h(n.html)});var d=H();A(d,r=>o=r,()=>o),v(u,d),C()}export{Y as R};
