import{t as y,a as k}from"./CTEcJb4s.js";import{p as x,a8 as C,a as E,g,a9 as L,G as S}from"./0-szhb9U.js";import{p as A}from"./BzflOjYQ.js";import{b as M}from"./CLtJoCDL.js";import{p as R}from"./B2LUClWd.js";import{o as T}from"./BuXCXmqg.js";import{i as j,s as _}from"./BLHenrGk.js";import{s as f,v as H}from"./Ca6lpuOR.js";/* empty css        */const q=`
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
    `;var z=y('<div class="shadow-host svelte-1kuj9kb"></div>');function O(h,c){x(c,!0),R(c,"id",3,"");let n,l=L(null);C(()=>{if(g(l)==null)return;const i=g(l).querySelectorAll(".dynamic");j.plugins.forEach(o=>{const s=o.globalVariables;i.forEach(t=>{var e;const a=(e=t.getAttribute("data-key"))==null?void 0:e.trim();a&&s[a]&&(t.textContent=s[a])})})});function b(i){const o=[],s=i.replace(/<script>([\s\S]*?)<\/script>/gi,(p,r)=>(o.push(r),"")),t=n.shadowRoot||n.attachShadow({mode:"open"});S(l,A(t)),t.innerHTML="";const a=document.createElement("style");a.textContent=q;const e=document.createElement("div");e.className="wrapper",e.id="wrapper",e.classList.add(f.isDark?"dark-mode":""),e.classList.add(f.animationSpeed),e.classList.add(f.primaryColor),e.innerHTML=s;const w=p=>{const r=p.target;if(r.matches("button.action")){const m=r.getAttribute("data-action");if(m!==null){console.log("Action triggered:",m);var v={kind:"pluginsAction",id:d,action:m};_.sendMessage(v)}}};t.addEventListener("click",w),t.appendChild(a),t.appendChild(e);const d="shadow"+H().toString();return window[d]=t,o.forEach(p=>{const r=document.createElement("script");r.textContent=`
          const document = window["${d}"];
          ${p}
        `,r.type="module",t.appendChild(r)}),()=>{t.removeEventListener("click",w)}}T(()=>{b(c.html)});var u=z();M(u,i=>n=i,()=>n),k(h,u),E()}export{O as R};
