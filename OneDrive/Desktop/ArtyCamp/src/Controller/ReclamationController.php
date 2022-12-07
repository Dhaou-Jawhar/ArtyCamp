<?php

namespace App\Controller;

use App\Entity\Reclamation;
use App\Form\recherchetype;
use App\Form\ReclamationType;
use App\Repository\ReclamationRepository;
use Doctrine\Persistence\ManagerRegistry;
use MercurySeries\FlashyBundle\FlashyNotifier;
use PHPMailer\PHPMailer\PHPMailer;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use Knp\Component\Pager\PaginatorInterface;
use Twilio;
use Twilio\Http\Client;


class ReclamationController extends AbstractController
{
    #[Route('/reclamation', name: 'app_reclamation')]
    public function index(): Response
    {
        return $this->render('reclamation/index.html.twig', [
            'controller_name' => 'ReclamationController',
        ]);
    }
    #[Route('/read', name: 'read_reclamation')]
    public function readreclamation(Request $request, PaginatorInterface $paginator):Response
    {$liste= $this->getDoctrine()->getRepository(Reclamation::class)->findAll();
        $liste = $paginator->paginate(
            $liste,
            $request->query->getInt('page', 1),
            5);
        return $this->render('reclamation/read.html.twig',['list1' => $liste]) ;
    }
    #[Route('/add', name: 'add_reclamation')]
    public function addreclamation(ManagerRegistry $doctrine,Request $Request, FlashyNotifier $flashy,/* ReclamationRepository $rec*/):Response
    {//$entitymanager = $doctrine->getManager();
        $obj= new Reclamation();
        $form = $this->createForm(ReclamationType::class,$obj);
        $form->handleRequest($Request);
        if(($form->isSubmitted())&&($form->isValid()))
        {
            $em=$doctrine->getManager();
            $em->persist($obj);
            $em->flush();
            $flashy->success('reclamation envoyée !!!', 'http://your-awesome-link.com');
            $mail = new PHPMailer(true);
            $mail->isSMTP();// Set mailer to use SMTP
            $mail->CharSet = "utf-8";// set charset to utf8
            $mail->SMTPAuth = true;// Enable SMTP authentication
            $mail->SMTPSecure = 'tls';// Enable TLS encryption, ssl also accepted
            $mail->Host = 'smtp.gmail.com';// Specify main and backup SMTP servers
            $mail->Port = 587;// TCP port to connect to
            $mail->SMTPOptions = array(
                'ssl' => array(
                    'verify_peer' => false,
                    'verify_peer_name' => false,
                    'allow_self_signed' => true
                )
            );
            $mail->isHTML(true);// Set email format to HTML
            $mail->Username = 'hanen.hammouda@esprit.tn';// SMTP username
            $mail->Password = '213JFT5490';// SMTP password
            $mail->setFrom('hanen.hammouda@esprit.tn', 'hanen hammouda');//Your application NAME and EMAIL
            $mail->Subject = 'reclamation bien créer';//Message subject
            $mail->Body = '<h1>Reclamation: ' . $obj->getMessage(). ' </h1>';

            $mail->addAddress('hanen.hammouda@esprit.tn', 'hanen hammouda');// Target email
            $mail->send();
            return $this->redirectToRoute('add_reclamation');
        }
        else{
            return $this->render('reclamation/add.html.twig',['f'=>$form->createView()]);

        }

    }
    #[Route('/supp/{idrec}', name: 'supp_reclamation')]
    public function supprimer($idrec,ManagerRegistry $doctrine):Response
    {$obj=$doctrine->getRepository(Reclamation::class)->find($idrec);
        $em=$doctrine->getManager();
        $em->remove($obj);
        $em->flush();
        return $this->redirectToRoute('read_reclamation');
    }
    #[Route('/updatee/{idrec}',name:'updatee')]
    public function update($idrec ,\Doctrine\Persistence\ManagerRegistry $doctrine,Request $REQUEST): Response
    { $obj=$doctrine
        ->getRepository(Reclamation::class)
        ->find($idrec);
        $form =$this->createForm(ReclamationType::class,$obj);
        $form ->add('modifier', SubmitType:: class);
        $form->handleRequest($REQUEST);
        if(($form->isSubmitted())&&( $form->isValid())){
            $em=$doctrine
                ->getManager();
            $em->flush(); //mise a jour de table w update
            return $this->redirectToRoute('read_reclamation');}
        else{
            return $this->renderForm('reclamation/update.html.twig',['f'=>$form]);
        }    }
   #[Route('/recherche',name:'rechercher')]
    public function rechercher(ReclamationRepository $reclamationRepository, Request $REQUEST){
        $listeR= $reclamationRepository->findAll();
        $form =$this->createForm(recherchetype::class);
      //  $form ->add('recherche', SubmitType:: class);
        $form->handleRequest($REQUEST);//traiter la requete
        if(($form->isSubmitted())){

            $Nom=$form['Nom']->getData();
            $listeR= $reclamationRepository->rechercheidrec($Nom);

            return $this->renderForm('reclamation/recherche.html.twig',['liste'=>$listeR,'f'=>$form]);}
        else{return $this->renderForm('reclamation/recherche.html.twig',['liste'=>$listeR,'f'=>$form]);

        }
    }
    #[Route('/trie',name:'trie')]
    public function trie(ReclamationRepository $reclamationRepository){
        $obj=$reclamationRepository->TrieQueryBuilder();
        return $this->render('reclamation/read.html.twig',['list1' =>$obj]) ;
    }
}
