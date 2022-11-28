import Vuex from "vuex";

import UserGuide from "./user-guide.vue";

export default {
  title: 'Styled/Templates/[PCFI] 사용자 가이드',
  components: { UserGuide },
};

export const Default = () => ({
  components: { UserGuide },
  template: '<UserGuide></UserGuide>',
});

export const TermsOfService = () => ({
  components: { UserGuide },
  template: '<UserGuide class-name="terms-of-service"></UserGuide>',
});
