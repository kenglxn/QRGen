<!DOCTYPE html>
<html>
<head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# githubog: http://ogp.me/ns/fb/githubog#">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <title>Deploy snapshots to Sonatype after Travis CI build</title>

  <meta content="authenticity_token" name="csrf-param" />
<meta content="tzx3zd3EjjTqLbF+x5UYULE3McxeX8uEvZOaJ0XJRIk=" name="csrf-token" />
  <meta name="viewport" content="width=960">

  <link type="text/plain" rel="author" href="https://github.com/humans.txt" />

  <meta content="gist" name="octolytics-app-id" /><meta content="collector.githubapp.com" name="octolytics-host" />

  <link href="https://gist.github.com/assets/application-1a163d807985dac0d994594ef2558571.css" media="screen, print" rel="stylesheet" />
  <script src="https://gist.github.com/assets/application-7d8a13b069fc44ac7cae88ab43791eeb.js"></script>

    <meta name="twitter:card" content="summary">
  <meta name="twitter:site" content="@github">
  <meta property="og:title" content="neothemachine/.travis.yml">
  <meta property="og:type" content="githubog:gist">
  <meta property="og:url" content="#{Gists.url}/neothemachine/4060735">
  <meta property="og:image" content="https://secure.gravatar.com/avatar/2d1de356f512a7d672c68690c8ca09ad?s=140&amp;d=https://github.com/images/gravatars/gravatar-140.png">
  <meta property="og:site_name" content="GitHub Gists">
  <meta property="og:description" content="Deploy snapshots to Sonatype after Travis CI build - Gist is a simple way to share snippets of text and code with others.">
  <meta name="description" content="Deploy snapshots to Sonatype after Travis CI build - Gist is a simple way to share snippets of text and code with others.">

</head>

<body class=" ">

  <div id="wrapper">
    

    <div id="header" class="header header-logged-out">
      <div class="container" class="clearfix">
        <a class="header-logo-wordmark" href="https://gist.github.com/"><span class="octicon octicon-logo-gist"></span></a>

        <div class="header-actions">
          <a class="button primary" href="https://github.com/signup?return_to=gist">Sign up for a GitHub Account</a>
          <a class="button" href="/login?return_to=/neothemachine/4060735" data-skip-pjax>Sign in</a>
        </div>
      </div>
    </div>

    <div class="site-content" id="js-pjax-container" data-pjax-container>
      <div class=" site-container js-site-container" data-url="/neothemachine/4060735">
  
  <meta content="true" name="octolytics-dimension-public" /><meta content="4060735" name="octolytics-dimension-gist_id" /><meta content="4060735" name="octolytics-dimension-gist_name" /><meta content="false" name="octolytics-dimension-anonymous" /><meta content="530988" name="octolytics-dimension-owner_id" /><meta content="neothemachine" name="octolytics-dimension-owner_login" /><meta content="false" name="octolytics-dimension-forked" />

<div class="pagehead repohead">
  <div class="container">
    <div class="title-actions-bar">
      <ul class="pagehead-actions">
      </ul>
      <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb" class="entry-title public">
        <span class="repo-label"><span>public</span></span>
        <span class="mega-octicon octicon-gist" ></span>
        <div class="meta">
          <div class="gist-author">
            <img src="https://secure.gravatar.com/avatar/2d1de356f512a7d672c68690c8ca09ad?s=140&amp;d=https://github.com/images/gravatars/gravatar-140.png" width="26" height="26">
            <span class="author vcard">
                <span itemprop="title"><a href="/neothemachine">neothemachine</a></span>
            </span> /
            <strong><a href="/neothemachine/4060735" class="js-current-repository">.travis.yml</a></strong>
          </div>
          <div class="gist-timestamp">
              <span class="datetime">Last updated <time class="js-relative-date" title="2013-02-18T19:23:03Z" datetime="2013-02-18T19:23:03Z">2013-02-18</time></span>
          </div>
      </h1>
    </div>

  </div>
</div>



<div class="gist-description container">
  <p>Deploy snapshots to Sonatype after Travis CI build</p>
</div>

<div class="gist container js-gist-container" data-version="8dba245765d61eed6884e40bdc92c120b085a887">
    <div class="root-pane">
  <div class="menu-container">
    <ul class="menu gisttabs">
      <li>
        <a href="/neothemachine/4060735" class="selected">
          Gist Detail
        </a>
      </li>

        <li class="revision-count">
          <a href="/neothemachine/4060735/revisions" >
            Revisions
            <span class="counter">9</span>
          </a>
        </li>

        <li>
          <a href="/neothemachine/4060735/stars" >
            Stars
            <span class="counter">5</span>
          </a>
        </li>

    </ul>
  </div>

  <ul class="export-references">
    <li>
      <a href="/neothemachine/4060735/download" class="minibutton" data-skip-pjax="true" rel="nofollow"><span class="octicon octicon-cloud-download"></span>Download Gist</a>
    </li>
    <li>
      <label for="url-field"><strong>Clone</strong> this gist</label>
      <input type="text" readonly spellcheck="false" class="url-field js-url-field js-cptoggle" name="url-field" value="https://gist.github.com/4060735.git" data-cptoggle-display="/neothemachine/4060735">
    </li>
    <li>
      <label for="embed-field"><strong>Embed</strong> this gist</label>
      <input type="text" readonly spellcheck="false" class="url-field js-url-field" name="embed-field" value="&lt;script src=&quot;https://gist.github.com/neothemachine/4060735.js&quot;&gt;&lt;/script&gt;">
    </li>
    <li>
      <label for="link-field"><strong>Link to</strong> this gist</label>
      <input type="text" readonly spellcheck="false" class="url-field js-url-field" name="link-field" value="https://gist.github.com/neothemachine/4060735">
    </li>
  </ul>
</div>


  <div class="column files">
        <div id="file-travis-yml" class="bubble">
          <div class="file-box ">
            <div class="meta">
              <div class="file-info">
                <span class="file-type-icon"><span class="octicon octicon-gist"></span></span>
                <strong class="file-name js-selectable-text">.travis.yml</strong>
              </div>
              <div class="file-actions">
                <span class="file-language">YAML</span>
                <ul class="button-group">
                  <li><a title="Permalink" href="#file-travis-yml" class="file-actions-button tooltipped downwards permalink"><span class="octicon octicon-link"></span></a></li>
                  <li><a title="View Raw" href="/neothemachine/4060735/raw/f7d4b0cf0a8ea1e7dd6b0024fd3bd35ced16acc9/.travis.yml" data-skip-pjax class="file-actions-button tooltipped downwards raw-url"><span class="octicon octicon-code"></span></a></li>
                </ul>
              </div>
            </div>
            <div class="suppressed">
              <a class="js-show-suppressed-file">File suppressed. Click to show.</a>
            </div>
            


  <div class="file-data">
    <table cellpadding="0" cellspacing="0" class="lines highlight">
      <tr>
        <td class="line-numbers">
          <span class="line-number" id="file-travis-yml-L1" rel="file-travis-yml-L1">1</span>
          <span class="line-number" id="file-travis-yml-L2" rel="file-travis-yml-L2">2</span>
          <span class="line-number" id="file-travis-yml-L3" rel="file-travis-yml-L3">3</span>
          <span class="line-number" id="file-travis-yml-L4" rel="file-travis-yml-L4">4</span>
          <span class="line-number" id="file-travis-yml-L5" rel="file-travis-yml-L5">5</span>
          <span class="line-number" id="file-travis-yml-L6" rel="file-travis-yml-L6">6</span>
          <span class="line-number" id="file-travis-yml-L7" rel="file-travis-yml-L7">7</span>
          <span class="line-number" id="file-travis-yml-L8" rel="file-travis-yml-L8">8</span>
          <span class="line-number" id="file-travis-yml-L9" rel="file-travis-yml-L9">9</span>
          <span class="line-number" id="file-travis-yml-L10" rel="file-travis-yml-L10">10</span>
        </td>
        <td class="line-data">
          <pre class="line-pre"><div class="line" id="file-travis-yml-LC1"><span class="l-Scalar-Plain">language</span><span class="p-Indicator">:</span> <span class="l-Scalar-Plain">java</span></div><div class="line" id="file-travis-yml-LC2">&nbsp;</div><div class="line" id="file-travis-yml-LC3"><span class="l-Scalar-Plain">env</span><span class="p-Indicator">:</span></div><div class="line" id="file-travis-yml-LC4">  <span class="l-Scalar-Plain">global</span><span class="p-Indicator">:</span></div><div class="line" id="file-travis-yml-LC5">    <span class="p-Indicator">-</span> <span class="l-Scalar-Plain">SONATYPE_USERNAME=yourusername</span></div><div class="line" id="file-travis-yml-LC6">    <span class="p-Indicator">-</span> <span class="l-Scalar-Plain">secure</span><span class="p-Indicator">:</span> <span class="s">&quot;your</span><span class="nv"> </span><span class="s">encrypted</span><span class="nv"> </span><span class="s">SONATYPE_PASSWORD=pass&quot;</span></div><div class="line" id="file-travis-yml-LC7">    </div><div class="line" id="file-travis-yml-LC8"><span class="l-Scalar-Plain">after_success</span><span class="p-Indicator">:</span></div><div class="line" id="file-travis-yml-LC9">  <span class="p-Indicator">-</span> <span class="l-Scalar-Plain">python addServer.py</span></div><div class="line" id="file-travis-yml-LC10">  <span class="p-Indicator">-</span> <span class="l-Scalar-Plain">mvn clean deploy --settings ~/.m2/mySettings.xml</span></div></pre>
        </td>
      </tr>
    </table>
  </div>

          </div>
        </div>
        <div id="file-readme-md" class="bubble">
          <div class="file-box ">
            <div class="meta">
              <div class="file-info">
                <span class="file-type-icon"><span class="octicon octicon-gist"></span></span>
                <strong class="file-name js-selectable-text">README.md</strong>
              </div>
              <div class="file-actions">
                <span class="file-language">Markdown</span>
                <ul class="button-group">
                  <li><a title="Permalink" href="#file-readme-md" class="file-actions-button tooltipped downwards permalink"><span class="octicon octicon-link"></span></a></li>
                  <li><a title="View Raw" href="/neothemachine/4060735/raw/e5eff89894a71dde3d59284c89c04a185da1bccd/README.md" data-skip-pjax class="file-actions-button tooltipped downwards raw-url"><span class="octicon octicon-code"></span></a></li>
                </ul>
              </div>
            </div>
            <div class="suppressed">
              <a class="js-show-suppressed-file">File suppressed. Click to show.</a>
            </div>
            
  <div class="readme context-loader-container context-loader-overlay" id="readme">
    <article class="markdown-body js-file "
        data-task-list-update-url="/neothemachine/4060735/file/README.md">
      <ol>
<li>
<a href="http://about.travis-ci.org/docs/user/build-configuration/#Secure-environment-variables">encrypt</a> your sonatype oss password with <code>travis encrypt -r user/repo SONATYPE_PASSWORD=pass</code>
</li>
<li>put addServer.py somewhere in your repository</li>
<li>add the relevant lines to your .travis.yml</li>
</ol><p>Deployment will only happen when the build was successful and the encrypted variables are available (= no deployment for pull requests etc.). If the deployment itself was unsuccessful, then the build still passes.</p>

<p>If you only want to deploy for certain branches, use shell scripting like:</p>

<pre><code>after_success:
  - "[[ $TRAVIS_BRANCH == \"master\" ]] &amp;&amp; { python travis/addServer.py; mvn clean deploy --settings ~/.m2/mySettings.xml; };"
</code></pre>

<p>Warning: This will deploy multiple times if you use the matrix functionality, see the <a href="https://github.com/travis-ci/travis-ci/issues/758#issuecomment-10329018">issue</a>.</p>
    </article>
  </div>



          </div>
        </div>
        <div id="file-addserver-py" class="bubble">
          <div class="file-box ">
            <div class="meta">
              <div class="file-info">
                <span class="file-type-icon"><span class="octicon octicon-gist"></span></span>
                <strong class="file-name js-selectable-text">addServer.py</strong>
              </div>
              <div class="file-actions">
                <span class="file-language">Python</span>
                <ul class="button-group">
                  <li><a title="Permalink" href="#file-addserver-py" class="file-actions-button tooltipped downwards permalink"><span class="octicon octicon-link"></span></a></li>
                  <li><a title="View Raw" href="/neothemachine/4060735/raw/b4cca25e7490800e5f10e5a2f3da510bf8dff99f/addServer.py" data-skip-pjax class="file-actions-button tooltipped downwards raw-url"><span class="octicon octicon-code"></span></a></li>
                </ul>
              </div>
            </div>
            <div class="suppressed">
              <a class="js-show-suppressed-file">File suppressed. Click to show.</a>
            </div>
            


  <div class="file-data">
    <table cellpadding="0" cellspacing="0" class="lines highlight">
      <tr>
        <td class="line-numbers">
          <span class="line-number" id="file-addserver-py-L1" rel="file-addserver-py-L1">1</span>
          <span class="line-number" id="file-addserver-py-L2" rel="file-addserver-py-L2">2</span>
          <span class="line-number" id="file-addserver-py-L3" rel="file-addserver-py-L3">3</span>
          <span class="line-number" id="file-addserver-py-L4" rel="file-addserver-py-L4">4</span>
          <span class="line-number" id="file-addserver-py-L5" rel="file-addserver-py-L5">5</span>
          <span class="line-number" id="file-addserver-py-L6" rel="file-addserver-py-L6">6</span>
          <span class="line-number" id="file-addserver-py-L7" rel="file-addserver-py-L7">7</span>
          <span class="line-number" id="file-addserver-py-L8" rel="file-addserver-py-L8">8</span>
          <span class="line-number" id="file-addserver-py-L9" rel="file-addserver-py-L9">9</span>
          <span class="line-number" id="file-addserver-py-L10" rel="file-addserver-py-L10">10</span>
          <span class="line-number" id="file-addserver-py-L11" rel="file-addserver-py-L11">11</span>
          <span class="line-number" id="file-addserver-py-L12" rel="file-addserver-py-L12">12</span>
          <span class="line-number" id="file-addserver-py-L13" rel="file-addserver-py-L13">13</span>
          <span class="line-number" id="file-addserver-py-L14" rel="file-addserver-py-L14">14</span>
          <span class="line-number" id="file-addserver-py-L15" rel="file-addserver-py-L15">15</span>
          <span class="line-number" id="file-addserver-py-L16" rel="file-addserver-py-L16">16</span>
          <span class="line-number" id="file-addserver-py-L17" rel="file-addserver-py-L17">17</span>
          <span class="line-number" id="file-addserver-py-L18" rel="file-addserver-py-L18">18</span>
          <span class="line-number" id="file-addserver-py-L19" rel="file-addserver-py-L19">19</span>
          <span class="line-number" id="file-addserver-py-L20" rel="file-addserver-py-L20">20</span>
          <span class="line-number" id="file-addserver-py-L21" rel="file-addserver-py-L21">21</span>
          <span class="line-number" id="file-addserver-py-L22" rel="file-addserver-py-L22">22</span>
          <span class="line-number" id="file-addserver-py-L23" rel="file-addserver-py-L23">23</span>
          <span class="line-number" id="file-addserver-py-L24" rel="file-addserver-py-L24">24</span>
          <span class="line-number" id="file-addserver-py-L25" rel="file-addserver-py-L25">25</span>
          <span class="line-number" id="file-addserver-py-L26" rel="file-addserver-py-L26">26</span>
          <span class="line-number" id="file-addserver-py-L27" rel="file-addserver-py-L27">27</span>
          <span class="line-number" id="file-addserver-py-L28" rel="file-addserver-py-L28">28</span>
          <span class="line-number" id="file-addserver-py-L29" rel="file-addserver-py-L29">29</span>
          <span class="line-number" id="file-addserver-py-L30" rel="file-addserver-py-L30">30</span>
          <span class="line-number" id="file-addserver-py-L31" rel="file-addserver-py-L31">31</span>
          <span class="line-number" id="file-addserver-py-L32" rel="file-addserver-py-L32">32</span>
          <span class="line-number" id="file-addserver-py-L33" rel="file-addserver-py-L33">33</span>
          <span class="line-number" id="file-addserver-py-L34" rel="file-addserver-py-L34">34</span>
          <span class="line-number" id="file-addserver-py-L35" rel="file-addserver-py-L35">35</span>
          <span class="line-number" id="file-addserver-py-L36" rel="file-addserver-py-L36">36</span>
          <span class="line-number" id="file-addserver-py-L37" rel="file-addserver-py-L37">37</span>
          <span class="line-number" id="file-addserver-py-L38" rel="file-addserver-py-L38">38</span>
          <span class="line-number" id="file-addserver-py-L39" rel="file-addserver-py-L39">39</span>
          <span class="line-number" id="file-addserver-py-L40" rel="file-addserver-py-L40">40</span>
          <span class="line-number" id="file-addserver-py-L41" rel="file-addserver-py-L41">41</span>
          <span class="line-number" id="file-addserver-py-L42" rel="file-addserver-py-L42">42</span>
          <span class="line-number" id="file-addserver-py-L43" rel="file-addserver-py-L43">43</span>
          <span class="line-number" id="file-addserver-py-L44" rel="file-addserver-py-L44">44</span>
          <span class="line-number" id="file-addserver-py-L45" rel="file-addserver-py-L45">45</span>
        </td>
        <td class="line-data">
          <pre class="line-pre"><div class="line" id="file-addserver-py-LC1"><span class="c">#!/usr/bin/env python</span></div><div class="line" id="file-addserver-py-LC2"><span class="kn">import</span> <span class="nn">sys</span></div><div class="line" id="file-addserver-py-LC3"><span class="kn">import</span> <span class="nn">os</span></div><div class="line" id="file-addserver-py-LC4"><span class="kn">import</span> <span class="nn">os.path</span></div><div class="line" id="file-addserver-py-LC5"><span class="kn">import</span> <span class="nn">xml.dom.minidom</span></div><div class="line" id="file-addserver-py-LC6">&nbsp;</div><div class="line" id="file-addserver-py-LC7"><span class="k">if</span> <span class="n">os</span><span class="o">.</span><span class="n">environ</span><span class="p">[</span><span class="s">&quot;TRAVIS_SECURE_ENV_VARS&quot;</span><span class="p">]</span> <span class="o">==</span> <span class="s">&quot;false&quot;</span><span class="p">:</span></div><div class="line" id="file-addserver-py-LC8">  <span class="k">print</span> <span class="s">&quot;no secure env vars available, skipping deployment&quot;</span></div><div class="line" id="file-addserver-py-LC9">  <span class="n">sys</span><span class="o">.</span><span class="n">exit</span><span class="p">()</span></div><div class="line" id="file-addserver-py-LC10">&nbsp;</div><div class="line" id="file-addserver-py-LC11"><span class="n">homedir</span> <span class="o">=</span> <span class="n">os</span><span class="o">.</span><span class="n">path</span><span class="o">.</span><span class="n">expanduser</span><span class="p">(</span><span class="s">&quot;~&quot;</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC12">&nbsp;</div><div class="line" id="file-addserver-py-LC13"><span class="n">m2</span> <span class="o">=</span> <span class="n">xml</span><span class="o">.</span><span class="n">dom</span><span class="o">.</span><span class="n">minidom</span><span class="o">.</span><span class="n">parse</span><span class="p">(</span><span class="n">homedir</span> <span class="o">+</span> <span class="s">&#39;/.m2/settings.xml&#39;</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC14"><span class="n">settings</span> <span class="o">=</span> <span class="n">m2</span><span class="o">.</span><span class="n">getElementsByTagName</span><span class="p">(</span><span class="s">&quot;settings&quot;</span><span class="p">)[</span><span class="mi">0</span><span class="p">]</span></div><div class="line" id="file-addserver-py-LC15">&nbsp;</div><div class="line" id="file-addserver-py-LC16"><span class="n">serversNodes</span> <span class="o">=</span> <span class="n">settings</span><span class="o">.</span><span class="n">getElementsByTagName</span><span class="p">(</span><span class="s">&quot;servers&quot;</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC17"><span class="k">if</span> <span class="ow">not</span> <span class="n">serversNodes</span><span class="p">:</span></div><div class="line" id="file-addserver-py-LC18">  <span class="n">serversNode</span> <span class="o">=</span> <span class="n">m2</span><span class="o">.</span><span class="n">createElement</span><span class="p">(</span><span class="s">&quot;servers&quot;</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC19">  <span class="n">settings</span><span class="o">.</span><span class="n">appendChild</span><span class="p">(</span><span class="n">serversNode</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC20"><span class="k">else</span><span class="p">:</span></div><div class="line" id="file-addserver-py-LC21">  <span class="n">serversNode</span> <span class="o">=</span> <span class="n">serversNodes</span><span class="p">[</span><span class="mi">0</span><span class="p">]</span></div><div class="line" id="file-addserver-py-LC22">  </div><div class="line" id="file-addserver-py-LC23"><span class="n">sonatypeServerNode</span> <span class="o">=</span> <span class="n">m2</span><span class="o">.</span><span class="n">createElement</span><span class="p">(</span><span class="s">&quot;server&quot;</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC24"><span class="n">sonatypeServerId</span> <span class="o">=</span> <span class="n">m2</span><span class="o">.</span><span class="n">createElement</span><span class="p">(</span><span class="s">&quot;id&quot;</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC25"><span class="n">sonatypeServerUser</span> <span class="o">=</span> <span class="n">m2</span><span class="o">.</span><span class="n">createElement</span><span class="p">(</span><span class="s">&quot;username&quot;</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC26"><span class="n">sonatypeServerPass</span> <span class="o">=</span> <span class="n">m2</span><span class="o">.</span><span class="n">createElement</span><span class="p">(</span><span class="s">&quot;password&quot;</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC27">&nbsp;</div><div class="line" id="file-addserver-py-LC28"><span class="n">idNode</span> <span class="o">=</span> <span class="n">m2</span><span class="o">.</span><span class="n">createTextNode</span><span class="p">(</span><span class="s">&quot;sonatype-nexus-snapshots&quot;</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC29"><span class="n">userNode</span> <span class="o">=</span> <span class="n">m2</span><span class="o">.</span><span class="n">createTextNode</span><span class="p">(</span><span class="n">os</span><span class="o">.</span><span class="n">environ</span><span class="p">[</span><span class="s">&quot;SONATYPE_USERNAME&quot;</span><span class="p">])</span></div><div class="line" id="file-addserver-py-LC30"><span class="n">passNode</span> <span class="o">=</span> <span class="n">m2</span><span class="o">.</span><span class="n">createTextNode</span><span class="p">(</span><span class="n">os</span><span class="o">.</span><span class="n">environ</span><span class="p">[</span><span class="s">&quot;SONATYPE_PASSWORD&quot;</span><span class="p">])</span></div><div class="line" id="file-addserver-py-LC31">&nbsp;</div><div class="line" id="file-addserver-py-LC32"><span class="n">sonatypeServerId</span><span class="o">.</span><span class="n">appendChild</span><span class="p">(</span><span class="n">idNode</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC33"><span class="n">sonatypeServerUser</span><span class="o">.</span><span class="n">appendChild</span><span class="p">(</span><span class="n">userNode</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC34"><span class="n">sonatypeServerPass</span><span class="o">.</span><span class="n">appendChild</span><span class="p">(</span><span class="n">passNode</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC35">&nbsp;</div><div class="line" id="file-addserver-py-LC36"><span class="n">sonatypeServerNode</span><span class="o">.</span><span class="n">appendChild</span><span class="p">(</span><span class="n">sonatypeServerId</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC37"><span class="n">sonatypeServerNode</span><span class="o">.</span><span class="n">appendChild</span><span class="p">(</span><span class="n">sonatypeServerUser</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC38"><span class="n">sonatypeServerNode</span><span class="o">.</span><span class="n">appendChild</span><span class="p">(</span><span class="n">sonatypeServerPass</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC39">&nbsp;</div><div class="line" id="file-addserver-py-LC40"><span class="n">serversNode</span><span class="o">.</span><span class="n">appendChild</span><span class="p">(</span><span class="n">sonatypeServerNode</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC41">  </div><div class="line" id="file-addserver-py-LC42"><span class="n">m2Str</span> <span class="o">=</span> <span class="n">m2</span><span class="o">.</span><span class="n">toxml</span><span class="p">()</span></div><div class="line" id="file-addserver-py-LC43"><span class="n">f</span> <span class="o">=</span> <span class="nb">open</span><span class="p">(</span><span class="n">homedir</span> <span class="o">+</span> <span class="s">&#39;/.m2/mySettings.xml&#39;</span><span class="p">,</span> <span class="s">&#39;w&#39;</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC44"><span class="n">f</span><span class="o">.</span><span class="n">write</span><span class="p">(</span><span class="n">m2Str</span><span class="p">)</span></div><div class="line" id="file-addserver-py-LC45"><span class="n">f</span><span class="o">.</span><span class="n">close</span><span class="p">()</span></div></pre>
        </td>
      </tr>
    </table>
  </div>

          </div>
        </div>
    <div id="comments" class="new-comments">
      
    </div>
      <p class="uncommentable"><span class="octicon octicon-alert"></span> Please <a href="/login?return_to=/neothemachine/4060735" rel="nofollow">sign in</a> to comment on this gist.</p>
  </div>
</div>

  <div class="context-overlay"></div>
</div>

    </div>
    <div class="slow-loading-overlay"></div>
  </div>

  <div id="ajax-error-message" class="flash flash-error">
    <div class="container">
      <span class="octicon octicon-alert"></span>
      Something went wrong with that request. Please try again.
      <a href="#" class="octicon octicon-remove-close ajax-error-dismiss"></a>
    </div>
  </div>

  <footer>
    <div id="footer">
  <div class="container clearfix">

    <!-- Served fresh by github-fe103-cp1-prd.iad.github.net -->
    <p class="right">&copy; 2013 GitHub Inc. All rights reserved.</p>
    <a class="left" href="/">
      <span class="mega-octicon octicon-mark-github"></span>
    </a>
    <ul id="legal">
      <li><a href="https://github.com/blog">The GitHub Blog</a></li>
      <li><a href="mailto:support@github.com">Support</a></li>
      <li><a href="https://github.com/contact">Contact</a></li>
    </ul>

  </div><!-- /.container -->
</div><!-- /.#footer -->

  </footer>

</body>
</html>
