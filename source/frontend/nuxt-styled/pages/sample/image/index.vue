<template lang="html">
  <div>
    <h1>{{ $t("image.title") }}</h1>
    <img :src="photo" />
    <form @submit="getPhotos">
      <label for="count">{{ $t("image.count") }}</label>
      <input type="number" id="count" v-model="count" value="10" min="1" max="50" step="1" />
      <button type="submit">{{ $t("image.submit") }}</button>
    </form>
    <br />
    <br />
    <img v-for="image in photos" :src="image.src" :key="image.id" @click="onClickPhoto(image.src)" />
  </div>
</template>

<i18n src="./index.json"></i18n>

<script type="text/javascript">
import { mapGetters, mapMutations, mapActions } from "vuex";

export default {
  name: "SampleImage",
  layout: "sample/sample",
  data() {
    return {
      count: 0
    };
  },
  computed: {
    ...mapGetters({
      photo: "sample/image/photo",
      photos: "sample/image/photos"
    })
  },
  async asyncData({ store, query }) {
    console.log("IMAGE FETCH START");
    let count = 5;
    if (query.count !== undefined) {
      count = query.count;
    }

    const photos = await store.dispatch("sample/image/getUserPhotos", count);
    store.commit("sample/image/setPhotos", photos);

    return { count };
  },
  methods: {
    ...mapActions({
      getUserPhotos: "sample/image/getUserPhotos"
    }),
    ...mapMutations({
      setPhoto: "sample/image/setPhoto",
      setPhotos: "sample/image/setPhotos"
    }),
    async getPhotos(e) {
      e.preventDefault();
      const photos = await this.getUserPhotos(this.count);
      this.setPhotos(photos);
    },
    onClickPhoto(src) {
      this.setPhoto(src);
    }
  }
};
</script>
