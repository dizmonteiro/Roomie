<template>
  <div class="box">
    <div class="columns">

        <div class="column">

            <div>
                <img
                  class="card-icon-right"
                  :src="require(`@/assets/svg/${imgName1}`)"
                  alt="card icon"
                />
                <div class="card-content">
                    <div class="buttons is-centered">
                      <a class="button is-small is-green is-rounded is-static vm">
                        {{headline1}}
                      </a>
                      <a class="button is-small is-green is-rounded vm" :href="link1">
                        Check House
                      </a>
                    </div>
                </div>
            </div>

            <div>
                <img
                  class="card-icon-right"
                  :src="require(`@/assets/svg/${imgName1}`)"
                  alt="card icon"
                />
                <div class="card-content">
                    <div class="buttons is-centered">
                      <a class="button is-small is-green is-rounded is-static vm">
                        {{headline1}}
                      </a>
                      <a class="button is-small is-green is-rounded vm" :href="link1">
                        Check House
                      </a>
                    </div>
                </div>
            </div>

        </div>

        <div class="column">

            <div>
                <img
                  class="card-icon-right"
                  :src="require(`@/assets/svg/${imgName1}`)"
                  alt="card icon"
                />
                <div class="card-content">
                    <div class="buttons is-centered">
                      <a class="button is-small is-green is-rounded is-static vm">
                        {{headline1}}
                      </a>
                      <a class="button is-small is-green is-rounded vm" :href="link1">
                        Check House
                      </a>
                    </div>
                </div>
            </div>

            <div>
                <img
                  class="card-icon-right"
                  :src="require(`@/assets/svg/${imgName1}`)"
                  alt="card icon"
                />
                <div class="card-content">
                    <div class="buttons is-centered">
                      <a class="button is-small is-green is-rounded is-static vm">
                        {{headline1}}
                      </a>
                      <a class="button is-small is-green is-rounded vm" :href="link1">
                        Check House
                      </a>
                    </div>
                </div>
            </div>

        </div>

        <div class="column">

            <div>
                <img
                  class="card-icon-right"
                  :src="require(`@/assets/svg/${imgName1}`)"
                  alt="card icon"
                />
                <div class="card-content">
                    <div class="buttons is-centered">
                      <a class="button is-small is-green is-rounded is-static vm">
                        {{headline1}}
                      </a>
                      <a class="button is-small is-green is-rounded vm" :href="link1">
                        Check House
                      </a>
                    </div>
                </div>
            </div>

            <div>
                <img
                  class="card-icon-right"
                  :src="require(`@/assets/svg/${imgName1}`)"
                  alt="card icon"
                />
                <div class="card-content">
                    <div class="buttons is-centered">
                      <a class="button is-small is-green is-rounded is-static vm">
                        {{headline1}}
                      </a>
                      <a class="button is-small is-green is-rounded vm" :href="link1">
                        Check House
                      </a>
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
  ]
};
</script>

<style src="../assets/styles/Card.css" scoped>