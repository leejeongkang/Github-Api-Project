export const state = () => ({
  _name: "cat" /**ignore**/,
  _photo: "https://a.wattpad.com/useravatar/Sundew_01.256.440713.jpg",
  _photos: []
});

export const getters = {
  name: (state) => state._name,
  photo: (state) => state._photo,
  photos: (state) => state._photos
};

export const mutations = {
  setName(state, data) {
    state._name = data;
  },
  setPhoto(state, data) {
    state._photo = data;
  },
  setPhotos(state, data) {
    state._photos = data;
  }
};

export const actions = {
  getUserPhotos({ state, commit }, data) {
    return this.$axios.get("/api/sample-images?count=" + data);
  }
};
