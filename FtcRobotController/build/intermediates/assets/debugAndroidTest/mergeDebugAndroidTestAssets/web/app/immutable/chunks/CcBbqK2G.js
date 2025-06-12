import{t as g,a as v}from"./Ctmd99_s.js";import{o as y,a2 as k,w as C,z as f,a3 as E,a4 as L}from"./D3A4CGZh.js";import{p as x}from"./A2gYBi8n.js";import{b as A}from"./Bcjp0Mr1.js";import{p as M}from"./eIz941wV.js";import{o as R}from"./Dl43FhjS.js";import{i as S,s as T}from"./KXYJspXy.js";import{s as c}from"./DnmOKHjr.js";var H=g('<div class="shadow-host"></div>');function F(u,n){y(n,!0);let w=M(n,"id",3,""),o,l=E(null);k(()=>{if(f(l)==null)return;const r=f(l).querySelectorAll(".dynamic");S.plugins.forEach(e=>{const i=e.globalVariables;r.forEach(t=>{var s;const a=(s=t.getAttribute("data-key"))==null?void 0:s.trim();a&&i[a]&&(t.textContent=i[a])})})});function b(r){const e=o.shadowRoot||o.attachShadow({mode:"open"});L(l,x(e)),e.innerHTML="";const i=document.createElement("style");i.textContent=`
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
    `;const t=document.createElement("div");t.className="wrapper",t.classList.add(c.isDark?"dark-mode":""),t.classList.add(c.animationSpeed),t.classList.add(c.primaryColor),t.innerHTML=r;const a=s=>{const m=s.target;if(m.matches("button.action")){const p=m.getAttribute("data-action");if(p!==null){console.log("Action triggered:",p);var h={kind:"pluginsAction",id:w(),action:p};T.sendMessage(h)}}};return e.addEventListener("click",a),e.appendChild(i),e.appendChild(t),()=>{e.removeEventListener("click",a)}}R(()=>{b(n.html)});var d=H();A(d,r=>o=r,()=>o),v(u,d),C()}export{F as R};
