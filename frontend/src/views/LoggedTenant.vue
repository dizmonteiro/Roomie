<template>
  <div>
    <TenantNavbar />
    <div
      class="columns is-centered is-vcentered is-mobile is-tablet is-desktop is-multiline"
    >
      <div class="column is-9-mobile is-9-tablet is-9-desktop">
        <div class="card-pages">
          <div class="columns">
            <div
              class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile"
            >
              <div v-for="h in column1" :key="h.id" class="block">
                <div class="card">
                  <img
                    object-fit="cover"
                    class="card-icon"
                    :src="require(`@/assets/svg/${h.imgName1}`)"
                    alt="card icon"
                  />
                  <div class="card-content">
                    <p class="title has-text-centered is-one-third">
                      {{ h.headline1 }}
                    </p>
                    <div class="content has-text-centered">{{ h.text1 }}</div>
                  </div>
                </div>
              </div>
            </div>
            <div
              class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile"
            >
              <div v-for="h in column2" :key="h.id" class="block">
                <div class="card">
                  <img
                    object-fit="cover"
                    class="card-icon"
                    :src="require(`@/assets/svg/${h.imgName1}`)"
                    alt="card icon"
                  />
                  <div class="card-content">
                    <p class="title has-text-centered is-one-third">
                      {{ h.headline1 }}
                    </p>
                    <div class="content has-text-centered">{{ h.text1 }}</div>
                  </div>
                </div>
              </div>
            </div>
            <div
              class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile"
            >
              <div v-for="h in column3" :key="h.id" class="block">
                <div class="card">
                  <img
                    object-fit="cover"
                    class="card-icon"
                    :src="require(`@/assets/svg/${h.imgName1}`)"
                    alt="card icon"
                  />
                  <div class="card-content">
                    <p class="title has-text-centered is-one-third">
                      {{ h.headline1 }}
                    </p>
                    <div class="content has-text-centered">{{ h.text1 }}</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="block">
            <pagination
              :selectedPage="1"
              :numberOfPages="6"
              @goBack="pageBack"
              @goForward="pageForward"
            >
            </pagination>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Pagination from "@/components/Pagination.vue";
import TenantNavbar from "@/components/TenantNavbar.vue";

export default {
  name: "LoggedTenant",
  components: { Pagination, TenantNavbar },

  data() {
    return {
      allinfo: [
        {
          id: 1,
          headline1: "Name Template 1",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 2,
          headline1: "Name Template 2",
          text1: "Template 1",
          imgName1: "house3.jpg",
          link1: "/",
        },
        {
          id: 3,
          headline1: "Name Template 3",
          text1: "Template 1",
          imgName1: "house2.jpg",
          link1: "/",
        },
        {
          id: 4,
          headline1: "Name Template 4",
          text1: "Template 1",
          imgName1: "house6.jpg",
          link1: "/",
        },
        {
          id: 5,
          headline1: "Name Template 5",
          text1: "Template 1",
          imgName1: "house7.jpg",
          link1: "/",
        },
        {
          id: 6,
          headline1: "Name Template 6",
          text1: "Template 1",
          imgName1: "house8.jpg",
          link1: "/",
        },
        {
          id: 7,
          headline1: "Name Template 7",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 8,
          headline1: "Name Template 8",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 9,
          headline1: "Name Template 9",
          text1: "Template 1",
          imgName1: "house5.jpg",
          link1: "/",
        },
        {
          id: 10,
          headline1: "Name Template 10",
          text1: "Template 1",
          imgName1: "house8.jpg",
          link1: "/",
        },
        {
          id: 11,
          headline1: "Name Template 11",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 12,
          headline1: "Name Template 12",
          text1: "Template 1",
          imgName1: "house5.jpg",
          link1: "/",
        },
        {
          id: 13,
          headline1: "Name Template 13",
          text1: "Template 1",
          imgName1: "house8.jpg",
          link1: "/",
        },
        {
          id: 14,
          headline1: "Name Template 14",
          text1: "Template 1",
          imgName1: "house8.jpg",
          link1: "/",
        },
        {
          id: 15,
          headline1: "Name Template 15",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 16,
          headline1: "Name Template 16",
          text1: "Template 1",
          imgName1: "house5.jpg",
          link1: "/",
        },
        {
          id: 17,
          headline1: "Name Template 17",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 18,
          headline1: "Name Template 18",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 19,
          headline1: "Name Template 19",
          text1: "Template 1",
          imgName1: "house8.jpg",
          link1: "/",
        },
        {
          id: 20,
          headline1: "Name Template 20",
          text1: "Template 1",
          imgName1: "house5.jpg",
          link1: "/",
        },
        {
          id: 21,
          headline1: "Name Template 21",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 22,
          headline1: "Name Template 22",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 23,
          headline1: "Name Template 23",
          text1: "Template 1",
          imgName1: "house8.jpg",
          link1: "/",
        },
        {
          id: 24,
          headline1: "Name Template 24",
          text1: "Template 1",
          imgName1: "house5.jpg",
          link1: "/",
        },
        {
          id: 25,
          headline1: "Name Template 25",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 26,
          headline1: "Name Template 26",
          text1: "Template 1",
          imgName1: "house8.jpg",
          link1: "/",
        },
        {
          id: 27,
          headline1: "Name Template 27",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 28,
          headline1: "Name Template 28",
          text1: "Template 1",
          imgName1: "house5.jpg",
          link1: "/",
        },
        {
          id: 29,
          headline1: "Name Template 29",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 30,
          headline1: "Name Template 30",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 31,
          headline1: "Name Template 31",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 32,
          headline1: "Name Template 32",
          text1: "Template 1",
          imgName1: "house8.jpg",
          link1: "/",
        },
        {
          id: 33,
          headline1: "Name Template 33",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 34,
          headline1: "Name Template 34",
          text1: "Template 1",
          imgName1: "house5.jpg",
          link1: "/",
        },
        {
          id: 35,
          headline1: "Name Template 35",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 36,
          headline1: "Name Template 36",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 37,
          headline1: "Name Template 37",
          text1: "Template 1",
          imgName1: "house8.jpg",
          link1: "/",
        },
        {
          id: 38,
          headline1: "Name Template 38",
          text1: "Template 1",
          imgName1: "house5.jpg",
          link1: "/",
        },
        {
          id: 39,
          headline1: "Name Template 39",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 40,
          headline1: "Name Template 40",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 41,
          headline1: "Name Template 41",
          text1: "Template 1",
          imgName1: "house8.jpg",
          link1: "/",
        },
        {
          id: 42,
          headline1: "Name Template 42",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 43,
          headline1: "Name Template 43",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 44,
          headline1: "Name Template 44",
          text1: "Template 1",
          imgName1: "house5.jpg",
          link1: "/",
        },
        {
          id: 45,
          headline1: "Name Template 45",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 46,
          headline1: "Name Template 46",
          text1: "Template 1",
          imgName1: "house8.jpg",
          link1: "/",
        },
        {
          id: 47,
          headline1: "Name Template 47",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 48,
          headline1: "Name Template 48",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 49,
          headline1: "Name Template 49",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 50,
          headline1: "Name Template 50",
          text1: "Template 1",
          imgName1: "house5.jpg",
          link1: "/",
        },
        {
          id: 51,
          headline1: "Name Template 51",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 52,
          headline1: "Name Template 52",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          id: 53,
          headline1: "Name Template 53",
          text1: "Template 1",
          imgName1: "house5.jpg",
          link1: "/",
        },
        {
          id: 54,
          headline1: "Name Template 54",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
      ],
      column1: [],
      column2: [],
      column3: [],
      indiceatual: 0,
    };
  },

  methods: {
    pageBack() {
      this.indiceatual -= 9;
      this.fillColumns(this.indiceatual);
      console.log(this.column1);
    },

    pageForward() {
      this.indiceatual += 9;
      this.fillColumns(this.indiceatual);
      console.log(this.column1);
    },

    fillColumns(start) {
      this.column1 = [];
      this.column2 = [];
      this.column3 = [];
      var i;
      for (i = start; i < start + 3 && i < this.allinfo.length; i++) {
        this.column1.push(this.allinfo[i]);
      }
      for (i = start + 3; i < start + 6 && i < this.allinfo.length; i++) {
        this.column2.push(this.allinfo[i]);
      }
      for (i = start + 6; i < start + 9 && i < this.allinfo.length; i++) {
        this.column3.push(this.allinfo[i]);
      }
    },

    onChange(page) {
      console.log(`Getting page ${page}`);
      console.log(page);
    },
  },

  created() {
    this.fillColumns(0);
  },
};
</script>

<style scoped>
#content {
  margin: 3% auto 2% auto;
  width: 100%;
}

.card-pages {
  align-items: center;
  margin-bottom: 5%;
  margin-top: 3%;
}

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