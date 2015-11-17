<p>This is a Gradle-based project that works best with
<a href="http://developer.android.com/sdk/installing/studio.html">Android Studio</a></p>

<p>To build the app:</p>

<ol>
<li><p>Install the following software:</p>

<ul>
<li>Android SDK:
 <a href="http://developer.android.com/sdk/index.html">http://developer.android.com/sdk/index.html</a></li>
<li>Gradle:
 <a href="http://www.gradle.org/downloads">http://www.gradle.org/downloads</a></li>
<li>Android Studio:
 <a href="http://developer.android.com/sdk/installing/studio.html">http://developer.android.com/sdk/installing/studio.html</a></li>
</ul></li>
<li><p>Run the Android SDK Manager by pressing the SDK Manager toolbar button
in Android Studio or by running the 'android' command in a terminal
window.</p></li>
<li><p>In the Android SDK Manager, ensure that the following are installed,
and are updated to the latest available version:</p>

<ul>
<li>Tools &gt; Android SDK Platform-tools</li>
<li>Tools &gt; Android SDK Tools</li>
<li>Tools &gt; Android SDK Build-tools</li>
<li>Tools &gt; Android SDK Build-tools</li>
<li>Android 6.0 &gt; SDK Platform (API 23)</li>
<li>Extras &gt; Android Support Repository</li>
<li>Extras &gt; Android Support Library</li>
<li>Extras &gt; Google Play services</li>
<li>Extras &gt; Google Repository</li>
</ul></li>
<li><p>Create a file in your working directory called local.properties,
containing the path to your Android SDK. Use local.properties.example as a
model.</p></li>
<li><p>Import the project in Android Studio:</p>

<ol>
<li>Press File &gt; Import Project</li>
<li>Navigate to and choose the build.gradle file in this project</li>
<li>Press OK</li>
</ol></li>
<li><p>Add your debug keystore to the project (save it as android/debug.keystore),
or modify the build.gradle file to point to your key.</p></li>
<li><p>Choose Build &gt; Make Project in Android Studio or run the following
command in the project root directory:</p>

<pre><code>./gradlew clean assembleDebug
</code></pre></li>
<li><p>To install on your test device:</p>

<pre><code>./gradlew installDebug
</code></pre></li>
</ol>