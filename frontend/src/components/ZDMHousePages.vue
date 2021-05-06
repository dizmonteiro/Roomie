<template>
    <div class="card-pages">
        <div class="columns is-centered is-desktop is-tablet is-mobile">
            <div class="column is-10">
              <div class="block">
                <ZDMHousePanel
                  class="current-element"
                  :headline1="currentElement.headline1"
                  :headline2="currentElement.headline2"
                  :headline3="currentElement.headline3"
                  :headline4="currentElement.headline4"
                  :headline5="currentElement.headline5"
                  :headline6="currentElement.headline6"
                  :headline7="currentElement.headline7"
                  :headline8="currentElement.headline8"
                  :headline9="currentElement.headline9"
                  :text1="currentElement.text1"
                  :text2="currentElement.text2"
                  :text3="currentElement.text3"
                  :text4="currentElement.text4"
                  :text5="currentElement.text5"
                  :text6="currentElement.text6"
                  :text7="currentElement.text7"
                  :text8="currentElement.text8"
                  :text9="currentElement.text9"
                  :imgName1="currentElement.imgName1"
                  :imgName2="currentElement.imgName2"
                  :imgName3="currentElement.imgName3"
                  :imgName4="currentElement.imgName4"
                  :imgName5="currentElement.imgName5"
                  :imgName6="currentElement.imgName6"
                  :imgName7="currentElement.imgName7"
                  :imgName8="currentElement.imgName8"
                  :imgName9="currentElement.imgName9"
                  :link1="currentElement.link1"
                  :link2="currentElement.link2"
                  :link3="currentElement.link3"
                  :link4="currentElement.link4"
                  :link5="currentElement.link5"
                  :link6="currentElement.link6"
                  :link7="currentElement.link7"
                  :link8="currentElement.link8"
                  :link9="currentElement.link9"
                />
              </div>
              <div class="columns is-centered is-one-third">
                <ZDMArrowButton
                  arrowType="left"
                  @click.native="showPrevElement"
                  :disabled="this.reachedMaxLeft"
                />
                <ZDMIndicators
                  :elements="this.panels"
                  :currentElementIndex="this.currentElementIndex"
                  :showElement="this.showElement"
                />
                <ZDMArrowButton
                  arrowType="right"
                  @click.native="showNextElement"
                  :disabled="this.reachedMaxRight"
                />
              </div>
            </div>
        </div>
    </div>
</template>
<script>
import ZDMHousePanel from "./ZDMHousePanel.vue";
import ZDMArrowButton from "./ZDMArrowButton.vue";
import ZDMIndicators from "./ZDMIndicators.vue";

export default {
  name: "ZDMHousePages",
  props: { panels: Array },
  components: { ZDMHousePanel, ZDMArrowButton, ZDMIndicators},

  data() {
    return {
      currentElementIndex: 0
    };
  },
  computed: {
    currentElement() {
      return this.panels[this.currentElementIndex];
    },
    reachedMaxLeft() {
      return this.currentElementIndex === 0;
    },
    reachedMaxRight() {
      return this.currentElementIndex === this.panels.length - 1;
    }
  },
  methods: {
    showNextElement() {
      this.currentElementIndex++;
    },
    showPrevElement() {
      this.currentElementIndex--;
    },
    showElement(elementIndex) {
      this.currentElementIndex = elementIndex;
    }
  }
};
</script>

<style scoped>

.card-pages {
  align-items: center;
  margin-bottom: 6%;
  margin-top: 4%;
}

.btn {
  height: 100%;
  border: none;
  background: transparent;
  cursor: pointer;
  opacity: 0.5;
}

.btn:focus {
  outline: none;
}

.btn:hover {
  opacity: 0.7;
}

.btn:disabled {
  opacity: 0.2;
  cursor: default;
}

</style>