import{t as y,a as k}from"./DdhgiPT7.js";import{p as x,u as C,a as E,g,b as L,e as A}from"./JIWhQ8jE.js";import{p as S}from"./cgOoaaI0.js";import{b as M}from"./Cko1okt-.js";import{p as R}from"./Bn6eXXEA.js";import{o as T}from"./DxECzNoP.js";import{i as j,s as _}from"./BSN0bPPh.js";import{s as m}from"./C6tIL26B.js";/* empty css        */var H=y('<div class="shadow-host svelte-1kuj9kb"></div>');function J(h,c){x(c,!0);let w=R(c,"id",3,""),n,l=L(null);C(()=>{if(g(l)==null)return;const i=g(l).querySelectorAll(".dynamic");j.plugins.forEach(o=>{const s=o.globalVariables;i.forEach(e=>{var t;const a=(t=e.getAttribute("data-key"))==null?void 0:t.trim();a&&s[a]&&(e.textContent=s[a])})})});function b(i){const o=[],s=i.replace(/<script>([\s\S]*?)<\/script>/gi,(p,r)=>(o.push(r),"")),e=n.shadowRoot||n.attachShadow({mode:"open"});A(l,S(e)),e.innerHTML="";const a=document.createElement("style");a.textContent=`
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
    `;const t=document.createElement("div");t.className="wrapper",t.id="wrapper",t.classList.add(m.isDark?"dark-mode":""),t.classList.add(m.animationSpeed),t.classList.add(m.primaryColor),t.innerHTML=s;const u=p=>{const r=p.target;if(r.matches("button.action")){const d=r.getAttribute("data-action");if(d!==null){console.log("Action triggered:",d);var v={kind:"pluginsAction",id:w(),action:d};_.sendMessage(v)}}};return e.addEventListener("click",u),e.appendChild(a),e.appendChild(t),o.forEach(p=>{const r=document.createElement("script");r.textContent=p,e.appendChild(r)}),()=>{e.removeEventListener("click",u)}}T(()=>{b(c.html)});var f=H();M(f,i=>n=i,()=>n),k(h,f),E()}export{J as R};
