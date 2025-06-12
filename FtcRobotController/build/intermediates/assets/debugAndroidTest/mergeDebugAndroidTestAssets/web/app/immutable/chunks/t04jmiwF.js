import{t as y,a as k}from"./DdhgiPT7.js";import{p as x,u as C,a as E,g,b as L,e as S}from"./JIWhQ8jE.js";import{p as A}from"./cgOoaaI0.js";import{b as M}from"./Cko1okt-.js";import{p as R}from"./Bn6eXXEA.js";import{o as T}from"./DxECzNoP.js";import{i as j,s as _}from"./BSN0bPPh.js";import{s as f,v as H}from"./C86mpzHe.js";/* empty css        */var q=y('<div class="shadow-host svelte-1kuj9kb"></div>');function K(h,c){x(c,!0),R(c,"id",3,"");let n,l=L(null);C(()=>{if(g(l)==null)return;const i=g(l).querySelectorAll(".dynamic");j.plugins.forEach(o=>{const s=o.globalVariables;i.forEach(e=>{var t;const a=(t=e.getAttribute("data-key"))==null?void 0:t.trim();a&&s[a]&&(e.textContent=s[a])})})});function b(i){const o=[],s=i.replace(/<script>([\s\S]*?)<\/script>/gi,(p,r)=>(o.push(r),"")),e=n.shadowRoot||n.attachShadow({mode:"open"});S(l,A(e)),e.innerHTML="";const a=document.createElement("style");a.textContent=`
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
    `;const t=document.createElement("div");t.className="wrapper",t.id="wrapper",t.classList.add(f.isDark?"dark-mode":""),t.classList.add(f.animationSpeed),t.classList.add(f.primaryColor),t.innerHTML=s;const w=p=>{const r=p.target;if(r.matches("button.action")){const m=r.getAttribute("data-action");if(m!==null){console.log("Action triggered:",m);var v={kind:"pluginsAction",id:d,action:m};_.sendMessage(v)}}};e.addEventListener("click",w),e.appendChild(a),e.appendChild(t);const d="shadow"+H().toString();return window[d]=e,o.forEach(p=>{const r=document.createElement("script");r.textContent=`
          const document = window["${d}"];
          ${p}
        `,r.type="module",e.appendChild(r)}),()=>{e.removeEventListener("click",w)}}T(()=>{b(c.html)});var u=q();M(u,i=>n=i,()=>n),k(h,u),E()}export{K as R};
