import { errorAlert } from "@functional/alert/alert-default";

export default function ({ $axios }) {
  function showLoader() {
    try {
      $nuxt.$loading.start();
    } catch (e) {}
  }

  function hideLoader() {
    try {
      $nuxt.$loading.finish();
    } catch (e) {}
  }

  $axios.onRequest((config) => {
    console.log("Making request to " + config.url);
    showLoader();
  });

  $axios.onResponse((response) => {
    hideLoader();
    let data = response.data;

    if (data.hasOwnProperty("result") && data.result === 0) {
      let errorMessage = data.errorMessage;
      if (errorMessage === null || errorMessage === "") {
        errorMessage = "시스템 오류가 발생 하였습니다.";
      }
      errorAlert(errorMessage).then(() => {
        return Promise.resolve(false);
      });
    }

    return data.data;
  });

  $axios.onError((error) => {
    hideLoader();
    console.error(error);
    errorAlert(error.msg).then(() => {
      return Promise.resolve(false);
    });
    return Promise.resolve(false);
  });
}
