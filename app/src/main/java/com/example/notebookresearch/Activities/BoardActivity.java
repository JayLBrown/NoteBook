package com.example.notebookresearch.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.notebookresearch.Models.PostModel;
import com.example.notebookresearch.MyCallBack;
import com.example.notebookresearch.R;
import com.example.notebookresearch.RecyclerViewAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BoardActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter = new RecyclerViewAdapter(this, getMyList());
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    public void readData(final MyCallBack callBack) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("posts");

        myRef.addValueEventListener(new ValueEventListener() {

            ArrayList<PostModel> models = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    PostModel m = snapshot.getValue(PostModel.class);
                    models.add(m);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private ArrayList<PostModel> getMyList() {

        ArrayList<PostModel> models = new ArrayList<>();

        PostModel m = new PostModel();
        m.setTitle("San Diego Summer Training Academy for Research Success (STAR)");
        m.setDecription("Summer Training Academy for Research Success\n" +
                "Welcome to STARS\n" +
                "Begin your application here (Deadline: January 30, 2020 at 5pm PST).\n" +
                "\n" +
                "application\n" +
                "\n" +
                "What is STARS?\n" +
                "The University of California, San Diego Summer Training Academy for Research Success (STARS) program is an eight-week summer research academy for community college students, undergraduate students, recent college graduates, and masters students. Opened to all disciplines, STARS offers student participants a rigorous research opportunity with esteemed UC San Diego faculty, informative transfer and graduate school preparation workshops, and educational, cultural, and social activities in sunny San Diego.\n" +
                "\n" +
                "Students will:\n" +
                "\n" +
                "Gain hands-on research experience with a faculty mentor's research project\n" +
                "Attend a GRE preparation course (students who are juniors or above)\n" +
                "Attend transfer and graduate school preparation workshops\n" +
                "Receive instruction on the transfer and graduate school application processes. Students will also receive instruction on graduate school fellowship applications, such as the National Science Foundation (NSF) Graduate Research and Ford Fellowships\n" +
                "Present research at the UCSD Summer Research Conference\n" +
                "Enjoy social activities with the cohort such as visiting the San Diego Zoo, beach trip, and the UCSD Challenge Course\n" +
                "Expand All\n" +
                "Eligibility\n" +
                "Applicant must\n" +
                "\n" +
                "Be 18 years of age\n" +
                "Be U.S. Citizens or Permanent Residents. AB 540 or DACA students are\n" +
                "Eligible\n" +
                "If you are an international student who has program funding and want to apply to the STARS program your program director may contact urstars@ucsd.edu for eligibility information.\n" +
                "Be interested in conducting full-time research in the summer for eight weeks with no commitments such as summer school, a full/part-time job\n" +
                "Demonstrate academic aptitude and achievement\n" +
                "Application Instructions\n" +
                " Personal Statement (max. 500 words) addressing the following points:\n" +
                "How did you become interested in your field of study?\n" +
                "What are your educational and career goals?\n" +
                "What experiences have contributed toward your preparation for your educational and career goals?\n" +
                "What are your research interests?\n" +
                "Why are you applying to STARS?\n" +
                "How are you a ?match? for STARS?\n" +
                "Optional: Describe background characteristics that may have placed you at an educational disadvantage (English language learner, family economic history, lack of educational opportunity, disability, etc.) and how you overcame them.\n" +
                "Do not include the faculty you want to work within this section unless you are already working with them. We will try to match you to the faculty you list in your application. But if we cannot we may send your personal statement to other faculty within your discipline.\n" +
                "CV/Resume\n" +
                "A copy of current Academic Transcripts (unofficial are OK)\n" +
                "Three (3) preferred UCSD faculty mentors should be listed within your application (not the personal statement nor the letters of recommendationS). The list of faculty mentors is available here.\n" +
                "Two (2) Letters of Recommendation from a counselor, faculty member, research mentor, principal investigator, etc.\n" +
                "Please ask your recommenders to email recommendations to urstars@ucsd.edu by January 30, 2020.\n" +
                "The letter should address the following questions:\n" +
                "What is your relationship to the applicant? Please include information on how long you have known the applicant and the extent of your interactions.\n" +
                "What is the applicant?s current research topic? If not actively involved in research, what are the applicant?s interests?\n" +
                "Please comment on the applicant?s academic merit including his/her aptitude for pursuing a Ph.D.\n" +
                "In your opinion, why and how would the applicant benefit from participating in STARS?\n" +
                "What is it about the applicant that leads you to recommend him/her for STARS?\n" +
                "Please ask your recommenders not to include the faculty you want to work with.\n" +
                "Selection\n" +
                "Applications will be evaluated based on:\n" +
                "\n" +
                "Cumulative or term GPA above 3.0\n" +
                "Relevance of completed courses to research interest\n" +
                "Writing skill\n" +
                "Compatibility of applicant's research interest with available faculty mentor research projects\n" +
                "Interest in pursuing a doctoral program\n" +
                "Letters of Recommendations\n" +
                "Funding\n" +
                "Participants may be funded by the Frontiers of Innovation Scholars Program from the UC San Diego Chancellor?s Office and through a variety of by undergraduate research programs at their home institutions, such as:\n" +
                "\n" +
                "Alliance for the Graduate Educations and the Professoriate (AGEP)\n" +
                "Building Infrastructure Leading to Diversity (BUILD)\n" +
                "California Pre-Doctoral Program\n" +
                "California Alliance for Minority Participation (CAMP)\n" +
                "Louis Stokes Alliance for Minority Preparation (LSAMP)\n" +
                "Howard Hughes Medical Institute (HHMI)\n" +
                "Minority Access to Research Careers (MARC)\n" +
                "Ronald E. McNair Achievement Program (McNair Scholars)\n" +
                "Research Industry Summer Experience (RISE)\n" +
                "UC Leadership Excellence through Advanced Degrees (UCLEADS)\n" +
                "We also welcome the opportunity to collaborate with other programs not currently listed. If you are in another program that can fund your summer research please ask your program director to email us at urstars@ucsd.edu.\n" +
                "\n" +
                "Application FAQs\n" +
                "Can I edit my application?\n" +
                "Yes, we now have an edit function available and you are able to edit your application and save the progress. However, you will not be able to make any changes once you have submitted the completed application.\n" +
                "\n" +
                "How shall Letters of Recommendations be submitted?\n" +
                "Please ask each recommender to email their recommendation letter directly to urstars@ucsd.edu by January 30, 2020. All letters must be submitted in PDF format and no other formats will be accepted. The file should be named, \"Students Last Name, Students First Name - Letter of Rec\".\n" +
                "Who can write my recommendation letter?\n" +
                "They can be written from a counselor, faculty member, research mentor, principal investigator, etc. but your recommendations should speak to your ability and academic potential in the field of study you are interested in.\n" +
                "Can my STARS Application be submitted at a different time from when my Letters of Recommendations are submitted?\n" +
                "Yes. Your STARS Application can be submitted earlier or later than when your Letters of Recommendations are submitted. If your STARS Application is submitted before we receive your Letters of Recommendations, we will upload a note in your application portal to let you know we have received both letters. If we receive Letters of Recommendations before we receive your Application, we will save your letters in your file and upload the note that we have both letters after your application has been submitted.\n" +
                "How do I choose which faculty to work with?\n" +
                "Prior to beginning your application please check the Research Projects 2020  page for the most up-to-date information on research opportunities this summer. You can choose from the list provided to you.\n" +
                "\n" +
                "Can I choose the faculty member I want to work with even if is not on the list?\n" +
                "If you are part of a graduate school preparation program (such as HHMI, McNair, UC LEADS) that has funding and that recommends you reach out to faculty directly to secure a research spot you may do so. Otherwise, please choose from the list provided in the Research Projects Page\n" +
                "\n" +
                "Can I apply as an international student?\n" +
                "Unfortunately, we are not accepting international students.  If you are an international student and have funding, your program director may contact urstars@ucsd.edu for eligibility information.\n" +
                "\n" +
                "Can I apply even if I?m a US Citizen living out of the country?\n" +
                "Yes, but STARS will only book domestic flights within the United States.\n" +
                "\n" +
                "Am I guaranteed to work with at least one of the faculty I request to be matched within my application?\n" +
                "No. Students are not guaranteed to be matched with the faculty they list in the application. We will try to match students to faculty related to the students listed major.\n" +
                "\n" +
                "If I include a faculty member I really want to work within my personal statement or recommendation letter, does that increase the chance of getting paired with the faculty member?\n" +
                "We recommend that you list the faculty you are interested in working within the application section that requests the names of faculty you want to work with. Faculty matching is not guaranteed. \n" +
                "\n" +
                "What if I need to arrive to the program late or leave early? Am I still eligible?\n" +
                "Students must commit to the full length of the program. Extenuating circumstances (i.e. classes beginning close to program end date) will be evaluated on a case by case basis.\n" +
                "\n" +
                "Expand All\n" +
                "All qualified applicants will be considered without regard to age, ancestry, citizenship, color, disability, gender, gender expression, gender identity, genetic information, marital status, medical condition, national origin, pregnancy, race, religion, sex, sexual orientation, veteran status as long as they have meet the eligibility criteria outlined above.  Selected applications may be forwarded to academic departments for faculty review and compatibility with faculty mentor research projects. All applicants will receive timely notification of status.");
        m.setImg(R.drawable.sand);
        models.add(m);

        PostModel a = new PostModel();
        a.setTitle("Science Undergraduate Laboratory Internship (SULI) Program");
        a.setDecription("Program Overview\n" +
                "Summer 2020 Term SULI Applications are due January 9, 2020. You can apply here.\n" +
                "\n" +
                "SLAC National Accelerator Laboratory is a world-renowned laboratory with research opportunities in physics, chemistry, materials and environmental sciences, astrophysics, scientific computing, and many engineering fields. SLAC?s summer internship program offers exciting opportunities for undergraduate students majoring in science or engineering to conduct research.\n" +
                "\n" +
                "The SULI Program is sponsored by the Department of Energy (DOE) Office of Science's Office of Workplace Development for Teachers and Scientists (WDTS).\n" +
                "\n" +
                "The 2020 summer program at SLAC runs for nine weeks, from June 22 to August 21. An optional 8-week program runs from June 22 to August 14.\n" +
                "\n" +
                "Students selected for internships receive:\n" +
                "\n" +
                "Stipends ($500/week)\n" +
                "Travel expenses\n" +
                "Free housing on Stanford University Campus\n" +
                "Students can purchase Cardinal Dollars which can be used for food at Stanford dining facilities and in several local restaurants and on campus\n" +
                "Find out what student alumni enjoy about their experiences!\n" +
                "\n" +
                "Research Opportunities\n" +
                "During the internship, each student works with a scientist or engineer on a project related to the Laboratory?s research program. At the conclusion of the internship, the student writes a research paper and makes a brief presentation on his or her project. Students also participate in a series of scientific lectures, professional development workshops and tours. Student projects range from solar-cell technology to astrophysics, from cancer drug research to particle physics and accelerator design, and from biocompatibility of medical devices to ultrafast (femtosecond) phenomena.\n" +
                "\n" +
                "To learn more about the research conducted at SLAC, click here.\n" +
                "\n" +
                "Descriptions of past SULI student projects:\n" +
                "\n" +
                "2015 SULI projects\n" +
                "2014 SULI projects\n" +
                "2013 SULI projects\n" +
                "Application Information\n" +
                "Who Should Apply:\n" +
                "\n" +
                "Students must be currently enrolled as a full-time undergraduate student at an accredited institution, and also have completed at least one year as a matriculating undergraduate student at the time of applying.  Applicants who will complete their undergraduate degree prior to the start of the internship may apply as a \"Graduating Senior\".  Please refer to the Eligibility requirements located here.\n" +
                "\n" +
                "Important Dates:\n" +
                "\n" +
                "Online Application Opens: October 16, 2019\n" +
                "Applications Due: January 9, 2020 at 5:00pm Eastern Time\n" +
                "Start Date (both 8 week and 9 week options): June 22, 2020\n" +
                "End Dates:    8 week option: August 14, 2020  -   9 week option: August 21, 2020\n" +
                " \n" +
                "Eligibility for SULI Internship:\n" +
                "\n" +
                "United States Citizen or Permanent Resident Alien\n" +
                "Must be at least 18 years or older at the time the internship begins\n" +
                "Undergraduate majoring in Science, Technology, Engineering or Math (STEM)\n" +
                "Must have a GPA of at least 3.0\n" +
                "Ability to commit to an 8 or 9 week program at SLAC\n" +
                "To Apply:\n" +
                "\n" +
                "Complete the Department of Energy's online SULI internship application\n" +
                "Specify SLAC as your first choice laboratory assignment\n" +
                "Send an e-mail to Enrique Cuellar expressing your interest in SLAC's program at cuellar@slac.stanford.edu\n" +
                "Program Deliverables\n" +
                "Program participants must complete the following:\n" +
                "\n" +
                "Must complete the full 8 or 9 week program. Students should expect to spend approximately 40 hours a week working on their projects or participating in development activities.\n" +
                "Must complete and submit a 6-8 page final paper and give a brief presentation of their summer research.\n" +
                "Must prepare and submit an abstract understandable brief oral presentation to a general audience.\n" +
                "Must behave in a responsible and professional manner. Please review Stanford?s Code of Conduct and SLAC?s Respectful Workplace Policy.\n" +
                "For more details on deliverables, visit: Science Undergraduate Laboratory Internships (SULI) Program Deliverables  Requirements and Guidelines.\n" +
                "\n" +
                "For More Information\n" +
                "Please visit the SULI website to learn more about the Science Undergraduate Laboratory Internship Program.\n" +
                "\n" +
                "Questions:\n" +
                "\n" +
                "If you have questions or need assistance, please contact:\n" +
                "\n" +
                "Enrique Cuellar\n" +
                "SULI Program Director\n" +
                "Email: cuellar@slac.stanford.edu");
        a.setImg(R.drawable.stanford);
        models.add(a);

        PostModel b = new PostModel();
        b.setTitle("Bioinspired Soft Materials Research Experience for Undergraduates");
        b.setDecription("\n" +
                "The Brandeis Materials Research Science and Engineering Center (MRSEC) announces its \"Bioinspired Soft Materials? Research Experience for Undergraduates (REU) program for Summer 2020. The REU is a summer research program that will fund undergraduate students assigned to MRSEC laboratories.\tQuestions?\n" +
                "E-mail Dr. Anique Olivier-Mason\n" +
                "What the MRSEC REU Offers\n" +
                "10 weeks of hands-on research in a Brandeis MRSEC laboratory\n" +
                "$5,000 stipend per student\n" +
                "Free housing & allowances for meals and travel\n" +
                "Grad school preparation, faculty mentoring, professional development and social engagement with other students on campus\n" +
                "Poster presentation at the end of the summer at the Annual Brandeis SciFest Celebration. \n" +
                " \n" +
                "\n" +
                "How to Apply\n" +
                "You will need to complete an online application. Use the link to the right to start the application process.\tApply to REU\n" +
                " \n" +
                "\n" +
                "Expand All / Collapse All\n" +
                "\n" +
                "\n" +
                "Program Details\n" +
                "Eligibility to Apply\n" +
                "Must be U.S. citizen or permanent resident\n" +
                "Must be currently enrolled in an undergraduate program (biology, chemistry, physics, materials science, bio-engineering, computer science, and related fields). Students from community colleges are strongly encouraged to apply.\n" +
                "Students from underrepresented minority groups, women, and individuals with disabilities are strongly encouraged to apply.\n" +
                "Application and Program Timeline\n" +
                "The application opens in October\n" +
                "\n" +
                "11:59 PM EST, February 1, 2020: ALL application components must be submitted in order to be considered for selection to the MRSEC REU cohort. Your application will not be considered if it is missing any required application components.\n" +
                "\n" +
                "We will start to review and consider applications before this date (rolling application) so the earlier you complete your application the better!\n" +
                "\n" +
                "Late February: Acceptance notifications\n" +
                "\n" +
                "Late May/early June - end of July/early August: 10 weeks of REU experience at Brandeis University\n" +
                "\n" +
                "Application Components\n" +
                "Background/identifying information\n" +
                "\n" +
                "Academic information\n" +
                "\n" +
                "Resume\n" +
                "\n" +
                "Transcript (we will accept unofficial transcripts)\n" +
                "\n" +
                "Responses to the two essay prompts below. Please note that your responses need to be copied into the online application submission form and that each essay should be ~2-4 paragraphs in length.\n" +
                "Please describe your previous research experience and correlate this previous research work to the theme of the Brandeis Materials Research Science and Engineering Center. Be sure to include the institution name(s), lab/PI name(s) and dates for each former experience.\n" +
                "State how participation in the MRSEC REU program will benefit your future academic and professional careers.\n" +
                "\n" +
                "Recommendation letters from two faculty members that are in a PDF format\n" +
                "\n" +
                "FAQs\n" +
                "How many students are selected to participate?\n" +
                "\n" +
                "There are 6-8 REU students in a summer cohort.\n" +
                "\n" +
                "Can a TA write my recommendation letter for MRSEC REU?\n" +
                "\n" +
                "Applicants are free to ask whomever they feel would provide the best support as to why they are strong contenders to participate in REU. However, it is best practice to connect with your professor/PI first.\n" +
                "I do not have any research experience, so how should I respond to the essay question about previous research experience?\n" +
                "\n" +
                "When you have limited or no research experience, it is best to describe a specific moment in a science class or a time at a museum (for example) that you became really curious and interested in a science topic. Consider writing about how you wanted to learn more?maybe that you started asking questions or were curious about the next steps in the research. Do not leave the question blank.\n" +
                "How can I make my essays better?\n" +
                "\n" +
                "In your essay(s), take the time to review potential mentors and have compelling reasons to be placed at one lab. In other words, research the research before applying. When writing about your experiences, provide context, details and motivation behind your work experiences and organization participation?don't just write a list. Also, show that you have energy and enthusiasm for the work and curiosity to learn more. Lastly, have your application proofread by someone you trust before you send it.\n" +
                "As a freshman, how can I get a letter of recommendation when I don't know my professors well?\n" +
                "\n" +
                "Differentiate yourself from the dozens of other students in class by making an appointment today with your science or math class professors. Go to their office hours. Ask questions in class. Get noticed. Ask questions about their classes and then say, \"I'd like your advice about getting into science research.\"\n" +
                "How could I make my letters of recommendation better?\n" +
                "\n" +
                "Make sure to ask the professors writing your letters of recommendation weeks ahead of the REU deadline if they are willing to write letters for you. Next, consider sending them your REU essay responses, resume and transcript. Remind them why you are awesome, why you are excited about this opportunity, and how the opportunity connects with your future goals.\n" +
                "Information about Previous Years' Cohorts\n" +
                "2019 REU and SMURF Students\n" +
                "2018 REU and SMURF Students\n" +
                "2017 REU and SMURF Students\n" +
                "2016 REU and SMURF Students\n" +
                "2015 REU\n" +
                "2014 REU\n" +
                "2013 REU");
        b.setImg(R.drawable.harvard2);
        models.add(b);

        PostModel ab = new PostModel();
        ab.setTitle("Research Experiences for Undergraduates in Software Engineering");
        ab.setDecription("Carnegie Mellon's Research Experiences for Undergraduates in Software Engineering (REUSE) program is an opportunity for undergraduate students to spend a summer working with some of the world's leading Software Engineering faculty researchers. A number of projects are available in diverse areas which may include automated bug repair, mining software repositories, green computing, requirements engineering, program analysis, programming languages, and usable programming tools. Accepted students will work closely with CMU faculty and researchers on research problems with the potential for publication and significant impact on the future practice of software engineering.\n" +
                "\n" +
                "Some of our past REUSE students have gone on to join top Ph.D. programs in computer science such as those at CMU, Berkeley, and the University of Washington; have published papers in major conferences; have won NSF graduate research fellowships; and have placed in the CRA's Outstanding Undergraduate award and ACM's student research competitions. We are excited to see what you can do!\n" +
                "\n" +
                "Special Note: We are especially interested in promoting research opportunities for students traditionally underrepresented in computer science, and for first- and second-year undergraduate students. Neither research experience nor advanced coursework in computer science or software engineering is required.\n" +
                "\n" +
                "What will you do?\n" +
                "Conduct cutting-edge research in interdisciplinary software engineering. Topics include: social analysis of software teams and organizations, software API usability, green computing, programming language design, security and privacy, automated program analysis and repair, self-adaptive systems and software development tools. For more information visit the Research page.\n" +
                "Spend 10 weeks at Carnegie Mellon University?s #1-ranked School of Computer Science.\n" +
                "Receive mentoring from world leaders in their fields.\n" +
                "Learn research skills in undergraduate seminars throughout the summer. For more information visit the Seminars page.\n" +
                "What will you get?\n" +
                "$5,000 stipend and $1,200 meal allowance\n" +
                "Travel to and from Carnegie Mellon\n" +
                "Air-conditioned campus housing\n" +
                "Social events throughout the summer (e.g., amusement parks, baseball games, and more!). For more information visit the Summer Experience page.\n" +
                "Who should apply?\n" +
                "You are interested in research in interdisciplinary software engineering.\n" +
                "You have demonstrated success in introductory undergraduate computer science courses.\n" +
                "You are a U.S. citizen, national, or permanent resident. \n" +
                "Note: Our major funding source, the National Science Foundation's Research Experience for Undergraduates (REU) program, will not support international students. However, international students may apply to work with one of our mentors and be funded from other sources. These students will not necessarily receive the same stipend, meal allowance, and housing as NSF funded students.\n" +
                "Support the REUSE Program\n" +
                "apply\n" +
                "Click Here to Apply Now\n" +
                "\n" +
                "important dates\n" +
                "Application Deadline\tFeb 1\n" +
                "Notification Date\tMar 1\n" +
                "Program Start Date\tMay 27\n" +
                "Program End Date\tAug 2\n" +
                "contact us\n" +
                "For questions, please contact:\n" +
                "\n" +
                "Joshua Sunshine\n" +
                "[Email]\n" +
                "412-268-1097");
        ab.setImg(R.drawable.car);
        models.add(ab);

        PostModel bb = new PostModel();
        bb.setTitle("Environmental Engineering Solutions for Pollution Prevention");
        bb.setDecription("Environmental Engineering Solutions for Pollution Prevention\n" +
                "The National Science Foundation REU Site at the University at Buffalo trains undergraduate researchers to address regional and global pollution concerns within three themes: detection, source control, and remediation.\n" +
                "\n" +
                "previous next\n" +
                "About the Program\n" +
                "2/21/19\n" +
                "The EESPP REU at the University Of Michigan is a 10-week summer program that builds upon the past ERIE-REU program by promoting air and water pollution projects.\n" +
                "About the University\n" +
                "2/19/19\n" +
                "UB is the premier public research university in the midwestern United States and the largest and most comprehensive campus in the 64-campus SUNY system.\n" +
                "About Buffalo\n" +
                "12/5/17\n" +
                "In a city as diverse as Buffalo, you can always find something fun to do, whether it's taking a leisurely walk in one of our glorious Olmsted-designed parks or taking in a thought-provoking work of art at dozens of art galleries.\n" +
                "Faculty Mentors & Projects\n" +
                "2/19/19\n" +
                "Meet our faculty mentors and see what they are researching this summer.\n" +
                "How to Apply\n" +
                "2/19/19\n" +
                "Learn about the REU program requirements and how to apply.\n" +
                "REU Photo Gallery\n" +
                "5/29/19\n" +
                "Browse our collection of images taken from EESPP research projects here at UB.\n" +
                "The 10-week summer program provides students with confidence and independence by conducting transformative research. \n" +
                "\n" +
                "Students must be U.S. citizens or permanent residents and be enrolled as undergraduate students in a college program through Fall 2018. Students from under-represented minority groups and non-research focused institutions are strongly encouraged to apply.");
        bb.setImg(R.drawable.m);
        models.add(bb);

        PostModel bbb = new PostModel();
        bbb.setTitle("REU program in the Department of Chemistry and Chemical Biology at Northeastern University");
        bbb.setDecription("Research Experiences for Undergraduates Program\n" +
                "The REU site program in the Department of Chemistry and Chemical Biology at Northeastern University offers interdisciplinary research opportunities in Biochemistry, Organic, Physical, Computational, and Analytical Chemistry laboratories with an overarching focus on the theme of Catalysis. Students will do research in a welcoming and vibrant academic setting with extensive connections to companies in the Boston area.\n" +
                "\n" +
                "APPLY HERE\n" +
                "\n" +
                "The research theme of the program will be Biological and Chemical Catalysis. This theme spans the multidisciplinary research areas represented in the department and will provide opportunities for students in the program to experience and discuss catalysis across the spectrum, from small molecule catalysts to enzymes. This is an important unifying theme through which students can be engaged in understanding chemistry from various perspectives through cutting edge research.\n" +
                "\n" +
                "The scientific problems to which students in the program will be exposed are as diverse as how enzyme catalysis is involved in the regulation of signal transduction pathways in the cell and green chemistry geared at sustainability. Students will get insight into the research methodology, self-discipline, teamwork and the dissemination of results through group meetings, poster presentations, and publications in professional journals.\n" +
                "\n" +
                "Each student will be an integral part of a research project, paired with a Northeastern graduate student mentor, and participate in weekly faculty seminars and informal discussion focused on catalysis from the perspectives of the various research groups. In addition, the REU site students will go on tours of companies in the Boston area and be involved in professional development workshops.\n" +
                "\n" +
                "The REU Program is open only to US citizens and permanent residents. The program is committed to the goal of increasing participation and inclusion in chemistry and chemical research. Students from schools with limited research opportunities, groups traditionally underrepresented in the sciences, and first generation college students are especially encouraged to apply.\n" +
                "\n" +
                "This program is based upon funding from the National Science Foundation REU Site Grant NSF CHE-1757078.\n" +
                "\n" +
                "Follow our Twitter!");
        bbb.setImg(R.drawable.east);
        models.add(bbb);

        PostModel bbba = new PostModel();
        bbba.setTitle("Cyberinfrastructure (CI) Research 4 Social Change");
        bbba.setDecription("The Cyberinfrastructure (CI) Research for Social Change Research Experience for Undergraduates (REU) at TACC is actively engaging 10 undergraduate students each summer for nine-weeks in solving real-world problems of national relevance, teaching them to not only be critical thinkers, but to be creative and reflective as well.\n" +
                "\n" +
                "Students gain skills in advanced programming and problem solving and use the CI to conduct cutting-edge research in engineering, science, and computational medicine. Research projects emphasize advanced computing as a tool to power discoveries that will impact social change for future generations.\n" +
                "\n" +
                "EXPERIENCE AT-A-GLANCE\n" +
                "The enriching and transformative experience at a world-class supercomputing center includes:\n" +
                "\n" +
                "Training in High Performance Computing (HPC), visualization, and data intensive computing\n" +
                "Mentoring by researchers at The University of Texas at Austin\n" +
                "Social and team-building activities on The University of Texas at Austin campus\n" +
                "Professional development and graduate school preparation\n" +
                "Leadership development opportunities to develop and enhance communication skills\n" +
                "Poster presentation, technical report, and publication opportunities\n" +
                "STIPEND\n" +
                "Participants will receive a stipend, housing (and meal card) at The University of Texas at Austin, and travel arranged by TACC. Additionally, travel grants to present research at an annual conference will be available to selected participants.\n" +
                "\n" +
                "APPLICATION & SELECTION\n" +
                "The application period for Summer 2020 is November 1 - March 1, 2020.\n" +
                "\n" +
                "Complete the application before March 1, 2020, 11:59pm CST.\n" +
                "Send an unofficial transcript to CIR4SC@tacc.utexas.edu. Selected participants will be required to submit an official transcript.\n" +
                "Secure commitment from two recommenders. These individuals should know your academic abilities and work ethic. At least one recommender should be college/university faculty. It is your responsibility to ask recommenders to complete the recommendation form by the March 1st application deadline.\n" +
                "Notifications of acceptance for Summer 2020: Rolling until March 15.\n" +
                "\n" +
                "ELIGIBILITY\n" +
                "Applicants must be a U.S. citizen or permanent resident of the United States; be and remain an undergraduate student in good standing; plan to complete an undergraduate degree program. Selected participants must be 18 years of age at the start of the program.\n" +
                "\n" +
                "CONTACT\n" +
                "Marques Bland, REU Recruitment Coordinator: mbland@tacc.utexas.edu.");
        bbba.setImg(R.drawable.texas2);
        models.add(bbba);


        PostModel cc = new PostModel();
        cc.setTitle("Biostatistics Epidemiology Summer Training Diversity Program");
        cc.setDecription("The Biostatistics Epidemiology Summer Training Diversity Program (BEST) was established to expand and diversify the behavioral and biomedical sciences? workforce by introducing undergraduates from underrepresented populations to biostatistics and cardiovascular and pulmonary disease research. Students representing racial and ethnic minority groups, disadvantaged backgrounds, and students with disabilities join the Department of Biostatistics at Columbia University?s Mailman School of Public Health?s for eight weeks of research, training, academic and career planning, and social activities around New York City.\n" +
                "\n" +
                "Following the success of the seven-student, 4-week pilot in 2008, BEST received a five-year grant from the National Heart, Lung and Blood Institute to expand the program to host 10-15 students for eight weeks each summer. All participants will receive a $2800 stipend as well as some funds to offset costs of food and travel to and from New York City. Students living outside of the NYC area have the option for free housing.\n" +
                "\n" +
                "Program Components\n" +
                "Participants undertake an individualized research project with a Columbia University faculty mentor, including a project symposium at the program?s conclusion.\n" +
                "\n" +
                "Other components of the program include:\n" +
                "\n" +
                "Course work in Introductory Biostatistics and Statistical Computing with SAS software\n" +
                "\n" +
                "A seminar series presented by Mailman School faculty and administrators\n" +
                "\n" +
                "Graduate school admissions counseling\n" +
                "\n" +
                "Training in research conduct and ethics\n" +
                "\n" +
                "Training in skills essential for graduate school success\n" +
                "\n" +
                "Social activities\n" +
                " \n" +
                "\n" +
                "The BEST Diversity Program is funded by a grant from NIH/NHLBI R25HL096260-11, the Office of the Dean, and the Department of Biostatistics at Columbia University?s Mailman School of Public Health.");
        cc.setImg(R.drawable.columbia);
        models.add(cc);

        PostModel bac = new PostModel();
        bac.setTitle("Warm-water aquatic ecology at University of Pennsylvania");
        bac.setDecription("Having access to safe and abundant potable water is quickly becoming one of the most important global environmental issues.  Some models predict that 40% of the world's population will suffer water shortages by 2025 due to several mechanisms, such as climate change, species invasions, and eutrophication.  These issues have been especially challenging in the southeastern U.S. given the on-going explosive population growth and prolonged drought throughout the region.  Unfortunately, less emphasis has been placed on the study of warm-water ecology (in contrast to ecological research in cooler, more temperate regions), thus creating a significant need for broadly-trained scientists capable of exploring complex, context-dependent natural and anthropogenic processes threatening water resources in warm regions of the world. \n" +
                "\n" +
                "This REU Site is a novel, collaborative effort involving Auburn University faculty mentors specializing in diverse but complementary disciplines, including community ecology, fisheries management, aquaculture, evolution, limnology, molecular biology,  microbiology, invasive species, fish behavior, outreach, physiology, parasitology, and conservation.  Together these disciplines provide the education basis for undergraduate students to learn about techniques and tools to study aquatic communities, specifically warm-water systems such as reservoirs, farm ponds, streams, and brackish estuaries.  The primary objectives of this project include exposing participants to different scientific hypotheses, research techniques, and ecological habitats and conditions in an engaging, interdisciplinary atmosphere that fosters a strong interest in aquatic sciences by the next generation of water experts. \n" +
                "\n" +
                "All REU students are fully supported during their experiences at Auburn University, including a $5,500 stipend, travel support to and from Auburn University, research funds ($500), and food and lodging in Auburn University dorms for the entire 10 week program (May 17 to July 26, 2020).\n" +
                "\n" +
                "Eligibility: All applicants who are interested in receiving NSF support must currently be a (1) U.S. citizen, U.S. national, or permanent resident and (2) an undergraduate freshman, sophomore, junior, or senior graduating no earlier than September 2020 or a high school senior that will start their undergraduate education the following fall semester after the REU program. We are especially encouraging students from traditionally under-represented groups in biology (i.e., African-Americans, Hispanic Americans, Native Americans, Alaska Natives, Native Hawaiians, other Pacific Islanders, students with disabilities, first generation college students, and U.S. veterans) as well as students from institutions with limited research opportunities (e.g., community colleges) or students in financial need to apply.\n" +
                "\n" +
                "International students: Although not financially supported by our REU Site, we are also open to including a few strongly motivated and self-funded international students in our REU Site research and professional development activities.\n" +
                "\n" +
                "----------\n" +
                "\n" +
                "2019 REU students\n" +
                "\n" +
                "Aaliyah Wright - Tuskegee University\n" +
                "\n" +
                "Catie Adams - Auburn University\n" +
                "\n" +
                "Cristina Garcia - Georgia Gwinnett College\n" +
                "\n" +
                "Diana Zurillo - Recinto Universitario de Mayagüez\n" +
                "\n" +
                "Elena Grandbois - Smith College\n" +
                "\n" +
                "Jenny Thieu - Clayton State University\n" +
                "\n" +
                "Jorge Lopez-Perez - Eckerd College\n" +
                "\n" +
                "Kathryn Cruz - Hampton University\n" +
                "\n" +
                "Miriam Hyman - Kenyon College\n" +
                "\n" +
                "Victoria Hallas - Worcester State University\n" +
                "\n" +
                "----------\n" +
                "\n" +
                "2018 REU students\n" +
                "\n" +
                "Caroline Cox - Young Harris College\n" +
                "\n" +
                "Zachary Davenport - Gallaudet University\n" +
                "\n" +
                "Andrew DeSana - Seton Hill University\n" +
                "\n" +
                "Ravon House - Lander University\n" +
                "\n" +
                "Sarah Leinbach - University of Maryland\n" +
                "\n" +
                "Serra Martin - Gadsden State Community College\n" +
                "\n" +
                "Bethany Pierce - Northwestern Oklahoma State University\n" +
                "\n" +
                "Katherine Stonecypher - Humboldt State University\n" +
                "\n" +
                "Emilia Torrellas - University of North Carolina at Charlotte\n" +
                "\n" +
                "Emily Waller - Rochester Institute of Technology\n" +
                "\n" +
                "----------\n" +
                "\n" +
                "2013 REU students\n" +
                "\n" +
                "Laura Alexander - University of Georgia (currently a PhD student at the Univ of Wisconsin)\n" +
                "\n" +
                "Crystal Bishop - Young Harris College (currently working at the Jones Ecological Research Center as a lab technician for the Entomology and Microbiology lab)\n" +
                "\n" +
                "Sarah Black - Valparaiso University (completed an MS at Southern Illinois Univ at Carbondale and currently a Junior Biologist for the US Army Corps of Engineers Regulatory Branch in the Detroit District)\n" +
                "\n" +
                "Mallary Clay - Catawba College (completed MS at Auburn Univ and currently teaching biology at Christ School in Asheville, NC)\n" +
                "\n" +
                "Laurel Low - Whitman College (currently an MS student at Yale University)\n" +
                "\n" +
                "Brooke Merrill - Michigan State University (currently a lab technician at Koppert Biological Systems)\n" +
                "\n" +
                "Jenae Olson - Minnesota State University - Moorhead (completed MS at Texas State Univ)\n" +
                "\n" +
                "Leslie Pope - North Georgia College and State Univ\n" +
                "\n" +
                "Miriam Schmid - Illinois Institute of Technology (completed an MS at Illinois Institute of Technology and currently teaching at Gwendolyn Brooks College Prep School)\n" +
                "\n" +
                "Anthony Scott - Livingstone College (currently working as a wildlife removal specialist)\n" +
                "\n" +
                "Deionta Sutton - North Carolina A&T University (currently working as a Quality Engineer)\n" +
                "\n" +
                "Shanell Thomas - Tuskegee University (currently a vet student at Tuskegee Univ)\n" +
                "\n" +
                "----------\n" +
                "\n" +
                "2012 REU students\n" +
                "\n" +
                "Evelyn Boardman - University of Vermont (completed MS at the Univ of Minnesota-Twin Cities and currently working as  Watershed Scientist at an environmental consulting firm in Vermont)\n" +
                "\n" +
                "Enrique Doster - Auburn University (currently a PhD/DVM student at Colorado State Univ)\n" +
                "\n" +
                "Kaitlin Driscoll - Eastern Washington University (currently working as a technician in an ecology lab at Montana State University)\n" +
                "\n" +
                "Kellie Fredette - Stetson University (currently an MS student at Auburn Univ)\n" +
                "\n" +
                "Brittany Holt - Tuskegee University (completed MS at Univ of Alabama at Birmingham and is currently the Regional Healthy Homes and Lead Coordinator for the Georgia Healthy Homes and Lead Poisoning Prevention program)\n" +
                "\n" +
                "Ryan Jiorle - William and Mary (completed MS at the Univ of Florida and currently working as a Fisheries Management Planner for the Virginia Marine Reources Commission in Newport News, Virginia)\n" +
                "\n" +
                "Kevin Koenders - University of Rochester (completed an MS in Medical Sciences at the Univ of Florida and is currently at Weill Cornell Medicine working in their Physician Assistant Program)\n" +
                "\n" +
                "Shirley Liao - Duke University (currently a PhD student at Harvard Univ)\n" +
                "\n" +
                "Alex Neal - University of Dayton (completed MS at Bowling Green State Univ)\n" +
                "\n" +
                "Trevor Starks - Kansas State University (completed MS at Oklahoma State Univ and currently a Stream Fisheries Technician for the Oklahoma Department of Wildlife Conservation)\n" +
                "\n" +
                "Rachel Zitomer - Humboldt State University (a recipient of an NSF Graduate Research Fellowship to attend Oregon State University for graduate school)\n" +
                "\n" +
                " \n" +
                "\n" +
                "----------\n" +
                "\n" +
                "2011 REU students\n" +
                "\n" +
                "Vernon Anderson - Auburn University (currently a vet student at Auburn Univ)\n" +
                "\n" +
                "Katie LeMay - University of West Alabama (completed MS at Texas A&M Univ at Corpus Christi and currently teaching in Port Lavaca, TX)\n" +
                "\n" +
                "Aiden Simpson - Clarion University (currently a Joint Fisheries Biologist with Western Pennsylvania Conservancy and Pennsylvania Fish and Boat Commission and the Unassessed Waters Program Coordinator)\n" +
                "\n" +
                "Michael Moore - University of Missouri - Columbia (completed MS at Virginia Tech University and currently a PhD student at the Univ of Missouri)\n" +
                "\n" +
                "Michael Andrews - University of South Carolina (currently an MS student at Cal State - Monterey Bay)\n" +
                "\n" +
                "Courtney Ellison - University of Georgia (currently a PhD student at the Indiana Univ and recipient of an NSF Graduate Research Fellowship)\n" +
                "\n" +
                "Harlan Gough - Western Washington University (currently a PhD student at the Univ of Florida)\n" +
                "\n" +
                "Kristen Carlisle - Jacksonville State University (currently working at the Southern Institute for Appropriate Technologyas the Clean Water and Nutrition Specialist)\n" +
                "\n" +
                "Kate Kohlenberg - University of Alabama - Birmingham (completed an MS at the Univ of Alabama at Birmingham and heading to St. Louis University to attend Physician Assistant school)\n" +
                "\n" +
                "Anthony Burger - Denison University (completed an MS student at Oklahomas State Univ and is currently working at the Career and Technology Education Center of Licking County as an instructor)\n" +
                "\n" +
                "Andrew Stump - Eastern Kentucky University(completed MS student at Eastern Kentucky Univ and is currently a Fisheries Biologist with the Kentucky Department of Fish and Wildlife Resources)");
        bac.setImg(R.drawable.upennlogo);
        models.add(bac);

        PostModel bq = new PostModel();
        bq.setTitle("Bioinspired Soft Materials Research Experience for Undergraduates");
        bq.setDecription("\n" +
                "The Brandeis Materials Research Science and Engineering Center (MRSEC) announces its \"Bioinspired Soft Materials? Research Experience for Undergraduates (REU) program for Summer 2020. The REU is a summer research program that will fund undergraduate students assigned to MRSEC laboratories.\tQuestions?\n" +
                "E-mail Dr. Anique Olivier-Mason\n" +
                "What the MRSEC REU Offers\n" +
                "10 weeks of hands-on research in a Brandeis MRSEC laboratory\n" +
                "$5,000 stipend per student\n" +
                "Free housing & allowances for meals and travel\n" +
                "Grad school preparation, faculty mentoring, professional development and social engagement with other students on campus\n" +
                "Poster presentation at the end of the summer at the Annual Brandeis SciFest Celebration. \n" +
                " \n" +
                "\n" +
                "How to Apply\n" +
                "You will need to complete an online application. Use the link to the right to start the application process.\tApply to REU\n" +
                " \n" +
                "\n" +
                "Expand All / Collapse All\n" +
                "\n" +
                "\n" +
                "Program Details\n" +
                "Eligibility to Apply\n" +
                "Must be U.S. citizen or permanent resident\n" +
                "Must be currently enrolled in an undergraduate program (biology, chemistry, physics, materials science, bio-engineering, computer science, and related fields). Students from community colleges are strongly encouraged to apply.\n" +
                "Students from underrepresented minority groups, women, and individuals with disabilities are strongly encouraged to apply.\n" +
                "Application and Program Timeline\n" +
                "The application opens in October\n" +
                "\n" +
                "11:59 PM EST, February 1, 2020: ALL application components must be submitted in order to be considered for selection to the MRSEC REU cohort. Your application will not be considered if it is missing any required application components.\n" +
                "\n" +
                "We will start to review and consider applications before this date (rolling application) so the earlier you complete your application the better!\n" +
                "\n" +
                "Late February: Acceptance notifications\n" +
                "\n" +
                "Late May/early June - end of July/early August: 10 weeks of REU experience at Brandeis University\n" +
                "\n" +
                "Application Components\n" +
                "Background/identifying information\n" +
                "\n" +
                "Academic information\n" +
                "\n" +
                "Resume\n" +
                "\n" +
                "Transcript (we will accept unofficial transcripts)\n" +
                "\n" +
                "Responses to the two essay prompts below. Please note that your responses need to be copied into the online application submission form and that each essay should be ~2-4 paragraphs in length.\n" +
                "Please describe your previous research experience and correlate this previous research work to the theme of the Brandeis Materials Research Science and Engineering Center. Be sure to include the institution name(s), lab/PI name(s) and dates for each former experience.\n" +
                "State how participation in the MRSEC REU program will benefit your future academic and professional careers.\n" +
                "\n" +
                "Recommendation letters from two faculty members that are in a PDF format\n" +
                "\n" +
                "FAQs\n" +
                "How many students are selected to participate?\n" +
                "\n" +
                "There are 6-8 REU students in a summer cohort.\n" +
                "\n" +
                "Can a TA write my recommendation letter for MRSEC REU?\n" +
                "\n" +
                "Applicants are free to ask whomever they feel would provide the best support as to why they are strong contenders to participate in REU. However, it is best practice to connect with your professor/PI first.\n" +
                "I do not have any research experience, so how should I respond to the essay question about previous research experience?\n" +
                "\n" +
                "When you have limited or no research experience, it is best to describe a specific moment in a science class or a time at a museum (for example) that you became really curious and interested in a science topic. Consider writing about how you wanted to learn more?maybe that you started asking questions or were curious about the next steps in the research. Do not leave the question blank.\n" +
                "How can I make my essays better?\n" +
                "\n" +
                "In your essay(s), take the time to review potential mentors and have compelling reasons to be placed at one lab. In other words, research the research before applying. When writing about your experiences, provide context, details and motivation behind your work experiences and organization participation?don't just write a list. Also, show that you have energy and enthusiasm for the work and curiosity to learn more. Lastly, have your application proofread by someone you trust before you send it.\n" +
                "As a freshman, how can I get a letter of recommendation when I don't know my professors well?\n" +
                "\n" +
                "Differentiate yourself from the dozens of other students in class by making an appointment today with your science or math class professors. Go to their office hours. Ask questions in class. Get noticed. Ask questions about their classes and then say, \"I'd like your advice about getting into science research.\"\n" +
                "How could I make my letters of recommendation better?\n" +
                "\n" +
                "Make sure to ask the professors writing your letters of recommendation weeks ahead of the REU deadline if they are willing to write letters for you. Next, consider sending them your REU essay responses, resume and transcript. Remind them why you are awesome, why you are excited about this opportunity, and how the opportunity connects with your future goals.\n" +
                "Information about Previous Years' Cohorts\n" +
                "2019 REU and SMURF Students\n" +
                "2018 REU and SMURF Students\n" +
                "2017 REU and SMURF Students\n" +
                "2016 REU and SMURF Students\n" +
                "2015 REU\n" +
                "2014 REU\n" +
                "2013 REUT");
        bq.setImg(R.drawable.berkeley);
        models.add(bq);

        return models;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.researchBoard) {
            Intent loginIntent = new Intent(this, BoardActivity.class);
            startActivity(loginIntent);


        } else if (item.getItemId() == R.id.questionnaire) {
            Intent searchIntent = new Intent(this, QuestionnaireActivity.class);
            startActivity(searchIntent);
        } else if (item.getItemId() == R.id.logout) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            Toast.makeText(this, "Signed out", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
