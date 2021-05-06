<template>
    <div class="columns is-desktop is-mobile is-tablet">

        <div class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile">

            <div class="block">
                <div class="card">
                    <img
                      object-fit="cover"
                      class="card-icon"
                      :src="require(`@/assets/svg/${imgName1}`)"
                      alt="card icon"
                    />
                    <div class="card-content">
                        <p class="title has-text-centered is-one-third">{{headline1}}</p>
                        <div class="content has-text-centered">
                            {{text1}}
                        </div>
                    </div>
                </div>
            </div>

            <div class="block">
                <div class="card">
                    <img
                      object-fit="cover"
                      class="card-icon"
                      :src="require(`@/assets/svg/${imgName4}`)"
                      alt="card icon"
                    />
                    <div class="card-content">
                        <p class="title has-text-centered is-one-third">{{headline4}}</p>
                        <div class="content has-text-centered">
                            {{text4}}
                        </div>
                    </div>
                </div>
            </div>

            <div class="block">
                <div class="card">
                    <img
                      object-fit="cover"
                      class="card-icon"
                      :src="require(`@/assets/svg/${imgName7}`)"
                      alt="card icon"
                    />
                    <div class="card-content">
                        <p class="title has-text-centered is-one-third">{{headline7}}</p>
                        <div class="content has-text-centered">
                            {{text7}}
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <div class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile">
            
            <div class="block">
                <div class="card">
                    <img
                      object-fit="cover"
                      class="card-icon"
                      :src="require(`@/assets/svg/${imgName2}`)"
                      alt="card icon"
                    />
                    <div class="card-content">
                        <p class="title has-text-centered is-one-third">{{headline2}}</p>
                        <div class="content has-text-centered">
                            {{text2}}
                        </div>
                    </div>
                </div>
            </div>

            <div class="block">
                <div class="card">
                    <img
                      object-fit="cover"
                      class="card-icon"
                      :src="require(`@/assets/svg/${imgName5}`)"
                      alt="card icon"
                    />
                    <div class="card-content">
                        <p class="title has-text-centered is-one-third">{{headline5}}</p>
                        <div class="content has-text-centered">
                            {{text5}}
                        </div>
                    </div>
                </div>
            </div>

            <div class="block">
                <div class="card">
                    <img
                      object-fit="cover"
                      class="card-icon"
                      :src="require(`@/assets/svg/${imgName8}`)"
                      alt="card icon"
                    />
                    <div class="card-content">
                        <p class="title has-text-centered is-one-third">{{headline8}}</p>
                        <div class="content has-text-centered">
                            {{text8}}
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <div class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile">

            <div class="block">
                <div class="card">
                    <img
                      object-fit="cover"
                      class="card-icon"
                      :src="require(`@/assets/svg/${imgName3}`)"
                      alt="card icon"
                    />
                    <div class="card-content">
                        <p class="title has-text-centered is-one-third">{{headline3}}</p>
                        <div class="content has-text-centered">
                            {{text3}}
                        </div>
                    </div>
                </div>
            </div>

            <div class="block">
                <div class="card">
                    <img
                      object-fit="cover"
                      class="card-icon"
                      :src="require(`@/assets/svg/${imgName6}`)"
                      alt="card icon"
                    />
                    <div class="card-content">
                        <p class="title has-text-centered is-one-third">{{headline6}}</p>
                        <div class="content has-text-centered">
                            {{text6}}
                        </div>
                    </div>
                </div>
            </div>

            <div class="block">
                <div class="card">
                    <img
                      object-fit="cover"
                      class="card-icon"
                      :src="require(`@/assets/svg/${imgName9}`)"
                      alt="card icon"
                    />
                    <div class="card-content">
                        <p class="title has-text-centered is-one-third">{{headline9}}</p>
                        <div class="content has-text-centered">
                            {{text9}}
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>
</template>

<script>
export default {
  name: "ZDMHousePanel",

  props: [
    "headline1","imgName1","text1","link1",
    "headline2","imgName2","text2","link2",
    "headline3","imgName3","text3","link3",
    "headline4","imgName4","text4","link4",
    "headline5","imgName5","text5","link5",
    "headline6","imgName6","text6","link6",
    "headline7","imgName7","text7","link7",
    "headline8","imgName8","text8","link8",
    "headline9","imgName9","text9","link9",
  ]
};
</script>

<style scoped>
.card {
  background-color: white;
  border-radius: 20px;
  box-shadow: 10% rgba(41, 67, 100, 0.21);
  width: 100%;
  height: auto;
  max-height: 450px;
  padding: 10% 10% 10% 10%;
}

.headline {
  font-weight: bold;
}

.card-icon {
  pointer-events: none;
  width: 100%;
  height: auto;
  max-height: 200px;
  padding: 2% 2% 2% 2%;
}

.card-content {
  width: 100%;
  height: auto;
  max-height: 200px;
  padding: 2% 2% 2% 2%;
}

</style>