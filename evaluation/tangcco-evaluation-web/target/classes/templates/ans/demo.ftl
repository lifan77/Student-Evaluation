﻿<!doctype html>
<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
  <meta charset="utf-8">
  <title>答题中！</title>
  <script src="/ans/js/jquery.min.js"></script>
  <style>
    /* Containers */
    html, body {
      min-height: 100%;
    }

    body {
      font-family: sans-serif;
      background: #42426b;
      background-image: -webkit-linear-gradient(135deg, #8067B7, #EC87C0);
      background-image: linear-gradient(-45deg, #8067B7, #EC87C0);
      color: rgba(255,255,255,.5);
    }

    .rb-box {
      width: 80%;
      max-width: 420px;
      margin: 50px auto;
      padding: 1.3em;
      background: #292942;
      border-radius: .75em;
      -webkit-filter: drop-shadow(1px 2px 5px rgba(0,0,0,.3));
      filter: drop-shadow(1px 2px 5px rgba(0,0,0,.3));
      box-shadow:
              0 2px 2px rgba(243,49,128,.5),
              0 0px 5px rgba(243,49,128,.15),
              0 0px 4px rgba(0,0,0,.35),
              0 5px 20px rgba(243,49,128,.25),
              0 15px 50px rgba(243,49,128,.75),
              inset 0 0 15px rgba(255,255,255,.05);
    }

    /* Custom Radio Button */
    p {
      font-size: .9em;
    }

    .rb {
      padding: 16px 0;
      text-align: center;
      background: rgba(255,255,255,.03);
      border-radius: .3em;
    }

    .rb-tab {
      display: inline-block;
      position: relative;
      width: 20%;
    }

    .rb-txt {
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      font-size: .5em;
      color: #FFFFFF;
    }

    .rb-spot {
      position: absolute;
      width: 18px;
      height: 18px;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      background: transparent;
      border: 1px solid rgba(255,255,255,.3);
      border-radius: 100%;
      cursor: pointer;
      transition: ease .5s;
    }

    .rb-tab-active .rb-spot {
      background: rgba(0,0,0,.35);
      border: 2px solid rgba(243,49,128,.6);
    }

    /* Submit Button */
    .button-box {
      padding: 10px 0;
      text-align: center;
    }

    button {
      display: inline-block;
      width: 80%;
      margin-top: 1.2em;
      padding: 1em;
      max-width: 220px;
      font-size: .9em;
      color: #D42D78;
      text-transform: uppercase;
      text-decoration: none;
      letter-spacing: .15em;
      background: white;
      border: none;
      outline: none;
      border-radius: 5em;
      box-shadow: 0 15px 20px -10px rgba(0, 0, 0, 0.3);
      transition:
              color 0.6s,
              box-shadow 0.3s,
              transform 0.3s;
      cursor: pointer;
    }

    button:hover {
      box-shadow: 0 3px 5px -5px rgba(0, 0, 0, 0.3);
      color: #6f6f6f;
    }</style>
</head>
<body>
<div class="rb-box">
  <#--<#list map?keys as key>
    <option value="${key}">${map[key]}</option>
  </#list>-->
  <form method="post" action="#">
    <!-- Radio Button Module -->
    <#list map?keys as key>
      <#--<option value="${key}">${map[key]}</option>-->
      <p>${key_index+1}.${key}</p>
      <div id="rb-${key_index+1}" class="rb">
            <#list map[key]?keys as yy>
                  <div class="rb-tab " data-value=${map[key][yy]}>
                    <div class="rb-spot">
                    <span class="rb-txt">${map[key][yy]}</span>
                  </div>
                </div><span >${yy}</span></br></br>
            </#list>
      </div>
    </#list>
    <#-- <div class="rb-tab" data-value="2">
            <div class="rb-spot">
              <span class="rb-txt">2</span>
            </div>
          </div>
          <div class="rb-tab" data-value="3">
            <div class="rb-spot">
              <span class="rb-txt">3</span>
            </div>
          </div>
          <div class="rb-tab" data-value="4">
            <div class="rb-spot">
              <span class="rb-txt">4</span>
            </div>
          </div>
          <div class="rb-tab" data-value="5">
            <div class="rb-spot">
              <span class="rb-txt">5</span>
            </div>
          </div>-->
  </form>
  <!--&lt;!&ndash; Radio Button Module &ndash;&gt;
  <p>2. On a scale of 1 to 5 how would you rate the universe?</p>
  <div id="rb-2" class="rb">
    <div class="rb-tab" data-value="1">
      <div class="rb-spot">
        <span class="rb-txt">1</span>
      </div>
    </div><div class="rb-tab rb-tab-active" data-value="2">
      <div class="rb-spot">
        <span class="rb-txt">2</span>
      </div>
    </div><div class="rb-tab" data-value="3">
      <div class="rb-spot">
        <span class="rb-txt">3</span>
      </div>
    </div><div class="rb-tab" data-value="4">
      <div class="rb-spot">
        <span class="rb-txt">4</span>
      </div>
    </div><div class="rb-tab" data-value="5">
      <div class="rb-spot">
        <span class="rb-txt">5</span>
      </div>
    </div>
  </div>

  &lt;!&ndash; Radio Button Module &ndash;&gt;
  <p>3. On a scale of 1 to 5 how much do you like stalactites?</p>
  <div id="rb-3" class="rb">
    <div class="rb-tab" data-value="1">
      <div class="rb-spot">
        <span class="rb-txt">1</span>
      </div>
    </div><div class="rb-tab" data-value="2">
      <div class="rb-spot">
        <span class="rb-txt">2</span>
      </div>
    </div><div class="rb-tab rb-tab-active" data-value="3">
      <div class="rb-spot">
        <span class="rb-txt">3</span>
      </div>
    </div><div class="rb-tab" data-value="4">
      <div class="rb-spot">
        <span class="rb-txt">4</span>
      </div>
    </div><div class="rb-tab" data-value="5">
      <div class="rb-spot">
        <span class="rb-txt">5</span>
      </div>
    </div>
  </div>

  &lt;!&ndash; Radio Button Module &ndash;&gt;
  <p>4. On a scale of 1 to 5 what is your favorite color in the alphabet?</p>
  <div id="rb-4" class="rb">
    <div class="rb-tab" data-value="1">
      <div class="rb-spot">
        <span class="rb-txt">1</span>
      </div>
    </div><div class="rb-tab" data-value="2">
      <div class="rb-spot">
        <span class="rb-txt">2</span>
      </div>
    </div><div class="rb-tab" data-value="3">
      <div class="rb-spot">
        <span class="rb-txt">3</span>
      </div>
    </div><div class="rb-tab rb-tab-active" data-value="4">
      <div class="rb-spot">
        <span class="rb-txt">4</span>
      </div>
    </div><div class="rb-tab" data-value="5">
      <div class="rb-spot">
        <span class="rb-txt">5</span>
      </div>
    </div>
  </div>

  &lt;!&ndash; Radio Button Module &ndash;&gt;
  <p>5. On a scale of one to shrimp, how random are you?</p>
  <div id="rb-5" class="rb">
    <div class="rb-tab" data-value="4">
      <div class="rb-spot">
        <span class="rb-txt">4</span>
      </div>
    </div><div class="rb-tab" data-value="2">
      <div class="rb-spot">
        <span class="rb-txt">2</span>
      </div>
    </div><div class="rb-tab" data-value="5">
      <div class="rb-spot">
        <span class="rb-txt">5</span>
      </div>
    </div><div class="rb-tab" data-value="1">
      <div class="rb-spot">
        <span class="rb-txt">1</span>
      </div>
    </div><div class="rb-tab rb-tab-active" data-value="3">
      <div class="rb-spot">
        <span class="rb-txt">3</span>
      </div>
    </div>
  </div>-->

  <!-- Button -->
  <div class="button-box">
    <button class="button trigger">Submit!</button>
  </div>

</div>


<script>
    /*
    ===============================================================

    Hi! Welcome to my little playground!

    My name is Tobias Bogliolo. 'Open source' by default and always 'responsive',
    I'm a publicist, visual designer and frontend developer based in Barcelona.

    Here you will find some of my personal experiments. Sometimes usefull,
    sometimes simply for fun. You are free to use them for whatever you want
    but I would appreciate an attribution from my work. I hope you enjoy it.

    ===============================================================
    */
    //Global:
    var survey = []; //Bidimensional array: [ [1,3], [2,4] ]

    //switcher function:
    $(".rb-tab").click(function(){
        //Spot switcher:
        $(this).parent().find(".rb-tab").removeClass("rb-tab-active");
        $(this).addClass("rb-tab-active");
    });

    //Save data:
    $(".trigger").click(function(){
        //Empty array:
        survey = [];
        //Push data:
        for (i=1; i<=$(".rb").length; i++) {
            var rb = "rb" + i;
            var rbValue = parseInt($("#rb-"+i).find(".rb-tab-active").attr("data-value"));
            console.log($("#rb-"+i).find(".rb-tab-active").children("div").children("span").text())
            //var rbValue=$("#rb-"+i).find(".rb-tab-active").attr("data-value");
            //Bidimensional array push:
            survey.push([i, rbValue]); //Bidimensional array: [ [1,3], [2,4] ]
        };
        //Debug:
        debug();
    });

    //Debug:
    function debug(){
        var debug = "";
        for (i=0; i<survey.length; i++) {
            debug += "No " + survey[i][0] + " = " + survey[i][1] + "\n";
        };
        alert(survey);
    };</script>
</body>
</html>
