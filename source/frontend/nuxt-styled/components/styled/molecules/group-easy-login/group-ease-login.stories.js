import GroupEasyLogin from "./group-ease-login.vue";

export default {
  title: 'Styled/Molecules/[PCFI] 간편 로그인',
  components: GroupEasyLogin,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 간편 로그인 </h2><story /></div>',
    }),
  ],
};

export const Default = () => ({
  components: { GroupEasyLogin },
  template: "<GroupEasyLogin></GroupEasyLogin>",
});
