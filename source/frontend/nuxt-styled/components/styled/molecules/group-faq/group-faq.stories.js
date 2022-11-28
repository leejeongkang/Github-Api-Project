
import GroupFaq from './group-faq.vue';

export default {
  title: 'Styled/Molecules/[PCFI] FAQ - 게시판형',
  components: GroupFaq,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) FAQ - 게시판형</h2><story /></div>' })],
};

export const Default = () => ({
  components: { GroupFaq },
  template: '<GroupFaq></GroupFaq>',
  methods: {}
});
